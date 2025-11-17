package com.example.java_automation_framework.config;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppConfig {
    private String baseUrl;
    private String username;
    private String password;
    private String projectName;
    private String taskProjectName;
}
