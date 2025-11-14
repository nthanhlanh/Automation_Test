package com.example.java_automation_framework.steps;

import com.example.java_automation_framework.pages.LoginPage;
import com.example.java_automation_framework.support.Context;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    private final Context context;
    private LoginPage loginPage;

    public LoginSteps(Context context) {
        this.context = context;
    }

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage = new LoginPage(context.getDriver());
    }

    @When("The user enters username {string}")
    public void the_user_enters_username(String userName) {
        loginPage.enterUsername(userName);
    }

    @And("The user clicks Continue")
    public void the_user_clicks_continue() {
        loginPage.clickContinue();
    }

    @And("The user enters password {string}")
    public void the_user_enters_password(String password) {
        loginPage.enterPassword(password);
    }

    @And("The user clicks Login")
    public void the_user_clicks_login() {
        loginPage.clickLogin();
    }

    @Then("The user sees the {string} title")
    public void the_user_see_the_title(String expectedTitle) {
        String actualTitle = loginPage.getTitleText();
        assertEquals(actualTitle, expectedTitle);
    }
}