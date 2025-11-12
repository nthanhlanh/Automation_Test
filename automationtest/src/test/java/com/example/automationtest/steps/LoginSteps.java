package com.example.automationtest.steps;

import com.example.automationtest.pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user opens the login page")
    public void user_opens_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // Khởi tạo Page Object
        loginPage = new LoginPage(driver);
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        // Gọi method login của Page Object
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("inventory"), "User is not on dashboard");
        driver.quit();
    }
}