package com.example.automationtest.steps;

import com.example.automationtest.models.User;
import com.example.automationtest.pages.LoginPage;
import com.example.automationtest.support.TestContext;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private TestContext context;

    public LoginSteps(TestContext context) {
        this.context = context;
    }

    @Given("user opens the login page")
    public void user_opens_the_login_page() {

        // Khởi tạo Page Object
        context.setLoginPage(new LoginPage(context.getDriver()));
    }

    @When("user logs in with user {user}")
    public void user_logs_in_with_user(User user) {
        context.getLoginPage().login(user.getUsername(), user.getPassword());
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        String currentUrl = context.getDriver().getCurrentUrl();
        assertTrue(currentUrl.contains("inventory"), "User is not on dashboard");
        context.getDriver().quit();
    }
}