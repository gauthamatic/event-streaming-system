terraform {
  required_providers {
    kafka = {
      source  = "Mongey/kafka"
      version = "~> 0.7.0"
    }
  }
}

provider "kafka" {
  bootstrap_servers = ["localhost:9092"]
}
