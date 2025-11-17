package com.example.java_automation_framework.steps.hooks;

import com.example.java_automation_framework.config.ConfigLoader;
import com.example.java_automation_framework.config.TestConfig;
import com.example.java_automation_framework.pages.LoginPage;
import com.example.java_automation_framework.driver.Context;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private final Context context;

    public Hooks(Context context) {
        this.context = context;
    }

    @Before(order = 0)
    public void beforeScenario() {
        context.getDriver();
    }

    @Before(value = "@requiresLogin", order = 1)
    public void setUp() {
        TestConfig config = ConfigLoader.getInstance().getConfig();
        LoginPage loginPage = new LoginPage(context.getDriver());
        loginPage.enterUsername(config.getUsername());
        loginPage.clickContinue();
        loginPage.enterPassword(config.getPassword());
        loginPage.clickLogin();
        loginPage.waitForElement(loginPage.getTitleLocator(), 30);
        loginPage.clickButtonOpenNewTab();
    }

    @After
    public void after() {
        if (context.getDriver() != null) {
            context.quitDriver();
        }
    }
}