# VPC for MSK
resource "aws_vpc" "kafka_vpc" {
  cidr_block           = "10.0.0.0/16"
  enable_dns_hostnames = true
  enable_dns_support   = true

  tags = {
    Name        = "kafka-vpc-${var.environment}"
    Environment = var.environment
  }
}

# Subnets
resource "aws_subnet" "kafka_subnet_1" {
  vpc_id            = aws_vpc.kafka_vpc.id
  cidr_block        = "10.0.1.0/24"
  availability_zone = "${var.aws_region}a"

  tags = {
    Name = "kafka-subnet-1-${var.environment}"
  }
}

resource "aws_subnet" "kafka_subnet_2" {
  vpc_id            = aws_vpc.kafka_vpc.id
  cidr_block        = "10.0.2.0/24"
  availability_zone = "${var.aws_region}b"

  tags = {
    Name = "kafka-subnet-2-${var.environment}"
  }
}

# Security Group
resource "aws_security_group" "kafka_sg" {
  name        = "kafka-sg-${var.environment}"
  description = "Security group for MSK cluster"
  vpc_id      = aws_vpc.kafka_vpc.id

  ingress {
    from_port   = 9092
    to_port     = 9092
    protocol    = "tcp"
    cidr_blocks = ["10.0.0.0/16"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "kafka-sg-${var.environment}"
  }
}

# MSK Cluster
resource "aws_msk_cluster" "kafka_cluster" {
  cluster_name           = "ride-sharing-kafka-${var.environment}"
  kafka_version          = "3.5.1"
  number_of_broker_nodes = 2

  broker_node_group_info {
    instance_type   = "kafka.t3.small"
    client_subnets  = [aws_subnet.kafka_subnet_1.id, aws_subnet.kafka_subnet_2.id]
    security_groups = [aws_security_group.kafka_sg.id]

    storage_info {
      ebs_storage_info {
        volume_size = 100
      }
    }
  }

  encryption_info {
    encryption_in_transit {
      client_broker = "TLS_PLAINTEXT"
      in_cluster    = true
    }
  }

  tags = {
    Name        = "ride-sharing-kafka-${var.environment}"
    Environment = var.environment
  }
}

output "msk_bootstrap_brokers" {
  value = aws_msk_cluster.kafka_cluster.bootstrap_brokers
}

output "vpc_id" {
  value = aws_vpc.kafka_vpc.id
}
