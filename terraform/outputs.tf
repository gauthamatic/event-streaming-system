output "topics_created" {
  value = [
    kafka_topic.ride_requests.name,
    kafka_topic.driver_locations.name,
    kafka_topic.ride_events.name,
    kafka_topic.ride_completed.name
  ]
}
