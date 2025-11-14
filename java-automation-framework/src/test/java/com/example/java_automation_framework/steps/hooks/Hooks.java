package com.example.java_automation_framework.steps.hooks;

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
        LoginPage loginPage = new LoginPage(context.getDriver());
        loginPage.enterUsername("lanh.nguyen@evizi.com");
        loginPage.clickContinue();
        loginPage.enterPassword("ABC@1991");
        loginPage.clickLogin();
    }

    @After
    public void after() {
        if (context.getDriver() != null) {
            context.quitDriver();
        }
    }
}