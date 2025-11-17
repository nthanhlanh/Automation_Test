package com.example.java_automation_framework.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class ConfigLoader {

    private static ConfigLoader instance;
    private final AppConfig config;

    private ConfigLoader() {
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.json")) {
            config = mapper.readValue(input, AppConfig.class);
        } catch (Exception e) {
            throw new RuntimeException("Cannot load config.json", e);
        }
    }

    public static ConfigLoader getInstance() {
        if (instance == null) {
            instance = new ConfigLoader();
        }
        return instance;
    }

    public AppConfig getConfig() {
        return config;
    }
}