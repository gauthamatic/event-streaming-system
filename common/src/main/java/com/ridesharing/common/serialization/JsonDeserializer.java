package com.ridesharing.common.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class JsonDeserializer<T> implements Deserializer<T> {

    private final ObjectMapper objectMapper;
    private Class<T> targetType;

    public JsonDeserializer() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public JsonDeserializer(Class<T> targetType) {
        this();
        this.targetType = targetType;
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        if (targetType == null) {
            String className = (String) configs.get("value.deserializer.type");
            if (className != null) {
                try {
                    targetType = (Class<T>) Class.forName(className);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("Cannot find class: " + className, e);
                }
            }
        }
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }
        try {
            return objectMapper.readValue(data, targetType);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing JSON to object", e);
        }
    }
}
