package com.example.java_automation_framework.support;

import com.example.java_automation_framework.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class Context {
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            driver = WebDriverFactory.getDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            WebDriverFactory.quitDriver();
        }
    }
}