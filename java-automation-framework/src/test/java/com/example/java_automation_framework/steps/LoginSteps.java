package com.example.java_automation_framework.steps;

import com.example.java_automation_framework.config.ConfigLoader;
import com.example.java_automation_framework.config.AppConfig;
import com.example.java_automation_framework.pages.LoginPage;
import com.example.java_automation_framework.driver.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {

    private final Context context;
    private LoginPage loginPage;
    private final AppConfig config;

    public LoginSteps(Context context) {
        this.context = context;
        this.config = ConfigLoader.getInstance().getConfig();
    }

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage = new LoginPage(context.getDriver());
    }

    @When("The user enters username")
    public void the_user_enters_username() {
        loginPage.enterUsername(config.getUsername());
    }

    @And("The user clicks Continue")
    public void the_user_clicks_continue() {
        loginPage.clickContinue();
    }

    @And("The user enters password")
    public void the_user_enters_password() {
        loginPage.enterPassword(config.getPassword());
    }

    @And("The user clicks Login")
    public void the_user_clicks_login() {
        loginPage.clickLogin();
    }

    @Then("The homepage is displayed")
    public void the_homepage_is_displayed() {
        Assertions.assertFalse(loginPage.getTitleText().isEmpty());
    }
}