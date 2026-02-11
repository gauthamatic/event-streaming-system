# AWS Deployment Guide

## Architecture
- **AWS MSK** (Managed Streaming for Kafka) - Kafka cluster
- **ECS Fargate** - Container orchestration for services
- **Application Load Balancer** - Traffic distribution
- **CloudWatch** - Logging and monitoring

## Prerequisites
- AWS CLI configured
- Terraform installed
- Docker installed

## Deployment Steps

### 1. Deploy Kafka (MSK)
```bash
cd terraform
terraform init
terraform apply -var="environment=prod"
```

Note the MSK bootstrap servers output.

### 2. Create Kafka Topics
Update `terraform/provider.tf` with MSK bootstrap servers, then:
```bash
terraform apply
```

### 3. Build Docker Images
```bash
gradle clean build
docker build -t producer-service:latest ./producer-service
docker build -t processor-service:latest ./processor-service
docker build -t analytics-service:latest ./analytics-service
```

### 4. Push to ECR
```bash
aws ecr create-repository --repository-name producer-service
aws ecr create-repository --repository-name processor-service
aws ecr create-repository --repository-name analytics-service

# Tag and push
docker tag producer-service:latest <account-id>.dkr.ecr.us-east-1.amazonaws.com/producer-service:latest
docker push <account-id>.dkr.ecr.us-east-1.amazonaws.com/producer-service:latest
# Repeat for other services
```

### 5. Deploy to ECS
Use AWS Console or Terraform to create:
- ECS Cluster
- Task Definitions (with environment variables)
- Services

### Environment Variables for Production
```
KAFKA_BOOTSTRAP_SERVERS=<msk-bootstrap-servers>
SPRING_PROFILES_ACTIVE=prod
SERVER_PORT=8080
```

## Local Development
```bash
docker-compose up -d
gradle bootRun
```

## Production Configuration Highlights
- **Idempotent producers** - No duplicate messages
- **Exactly-once processing** - Kafka Streams guarantee
- **Compression** - Snappy for network efficiency
- **Retries** - Automatic retry on failures
- **Health checks** - Spring Actuator endpoints
