package com.example.automationtest.steps;

import com.example.automationtest.models.User;
import io.cucumber.java.ParameterType;

public class CustomParameterTypes {

    // Regex: lấy dạng "username/password"
    @ParameterType(".*?/.*?")
    public User user(String input) {
        String[] parts = input.split("/");
        return new User(parts[0], parts[1]);
    }
}