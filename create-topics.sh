#!/bin/bash

echo "Creating Kafka topics..."

docker exec kafka kafka-topics --create \
  --bootstrap-server localhost:9092 \
  --topic ride-requests \
  --partitions 3 \
  --replication-factor 1 \
  --if-not-exists

docker exec kafka kafka-topics --create \
  --bootstrap-server localhost:9092 \
  --topic driver-locations \
  --partitions 3 \
  --replication-factor 1 \
  --if-not-exists

docker exec kafka kafka-topics --create \
  --bootstrap-server localhost:9092 \
  --topic ride-events \
  --partitions 3 \
  --replication-factor 1 \
  --if-not-exists

docker exec kafka kafka-topics --create \
  --bootstrap-server localhost:9092 \
  --topic ride-completed \
  --partitions 3 \
  --replication-factor 1 \
  --if-not-exists

echo "Listing all topics:"
docker exec kafka kafka-topics --list --bootstrap-server localhost:9092
