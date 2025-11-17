package com.example.java_automation_framework.driver;

import com.example.java_automation_framework.config.ConfigLoader;
import com.example.java_automation_framework.config.AppConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            AppConfig config = ConfigLoader.getInstance().getConfig();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(config.getBaseUrl());
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void refreshDriver() {
        if (driver != null) {
            driver.navigate().refresh();
        }
    }
}