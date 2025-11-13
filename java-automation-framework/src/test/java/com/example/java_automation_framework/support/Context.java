package com.example.java_automation_framework.support;

import com.example.java_automation_framework.pages.LoginPage;
import com.example.java_automation_framework.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class Context {
    private final WebDriver driver;
    private LoginPage loginPage;

    public Context() {
        this.driver = WebDriverFactory.getDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }
}