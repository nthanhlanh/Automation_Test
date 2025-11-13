package com.example.java_automation_framework.steps;

import com.example.java_automation_framework.pages.LoginPage;
import com.example.java_automation_framework.support.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    private final Context context;

    public LoginSteps(Context context) {
        this.context = context;
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        context.setLoginPage(new LoginPage(context.getDriver()));
    }

    @When("user enters username {string}")
    public void user_enters_username(String userName) {
        context.getLoginPage().enterUsername(userName);
    }

    @And("the user clicks Continue")
    public void the_user_clicks_continue() {
        context.getLoginPage().clickContinue();
    }

    @And("the user enters password {string}")
    public void the_user_enters_password(String password) {
        context.getLoginPage().enterPassword(password);
    }

    @And("the user clicks Login")
    public void the_user_clicks_login() {
        context.getLoginPage().clickLogin();
    }

    @Then("the {string} title is displayed on the dashboard")
    public void the_title_is_displayed_on_the_dashboard(String expectedTitle) {
        String actualTitle = context.getLoginPage().getTitleText();
        assertEquals(actualTitle, expectedTitle);
        context.getDriver().quit();
    }
}