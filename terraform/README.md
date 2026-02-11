# Kafka Topic Configuration with Terraform

## Prerequisites
- Terraform installed
- Kafka running (via docker-compose)

## Usage

1. Start Kafka:
```bash
docker-compose up -d
```

2. Initialize Terraform:
```bash
cd terraform
terraform init
```

3. Plan the changes:
```bash
terraform plan
```

4. Apply the configuration:
```bash
terraform apply
```

5. Verify topics:
```bash
docker exec kafka kafka-topics --list --bootstrap-server localhost:9092
```

## Destroy Topics
```bash
terraform destroy
```
