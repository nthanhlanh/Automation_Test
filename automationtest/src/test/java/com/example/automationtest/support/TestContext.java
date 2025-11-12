package com.example.automationtest.support;

import com.example.automationtest.pages.LoginPage;
import com.example.automationtest.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class TestContext {
    private WebDriver driver;
    private LoginPage loginPage;

    public TestContext() {
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