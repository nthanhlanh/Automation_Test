package com.example.java_automation_framework.config;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TestConfig {
    private String baseUrl;
    private String username;
    private String password;
}
