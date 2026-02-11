resource "kafka_topic" "ride_requests" {
  name               = "ride-requests"
  replication_factor = 1
  partitions         = 3

  config = {
    "retention.ms" = "604800000" # 7 days
  }
}

resource "kafka_topic" "driver_locations" {
  name               = "driver-locations"
  replication_factor = 1
  partitions         = 3

  config = {
    "retention.ms" = "86400000" # 1 day
  }
}

resource "kafka_topic" "ride_events" {
  name               = "ride-events"
  replication_factor = 1
  partitions         = 3

  config = {
    "retention.ms" = "604800000" # 7 days
  }
}

resource "kafka_topic" "ride_completed" {
  name               = "ride-completed"
  replication_factor = 1
  partitions         = 3

  config = {
    "retention.ms" = "2592000000" # 30 days
  }
}

output "topics_created" {
  value = [
    kafka_topic.ride_requests.name,
    kafka_topic.driver_locations.name,
    kafka_topic.ride_events.name,
    kafka_topic.ride_completed.name
  ]
}
