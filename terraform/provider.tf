terraform {
  required_providers {
    kafka = {
      source  = "Mongey/kafka"
      version = "~> 0.7.0"
    }
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "kafka" {
  bootstrap_servers = ["localhost:9092"]
}

provider "aws" {
  region = var.aws_region
}

variable "aws_region" {
  default = "us-east-1"
}

variable "environment" {
  default = "dev"
}
