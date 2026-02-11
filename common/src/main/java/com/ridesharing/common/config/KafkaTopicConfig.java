package com.ridesharing.common.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic rideRequestsTopic() {
        return TopicBuilder.name("ride-requests")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic driverLocationsTopic() {
        return TopicBuilder.name("driver-locations")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic rideEventsTopic() {
        return TopicBuilder.name("ride-events")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic rideCompletedTopic() {
        return TopicBuilder.name("ride-completed")
                .partitions(3)
                .replicas(1)
                .build();
    }
}
