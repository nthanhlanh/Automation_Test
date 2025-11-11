package com.example.automationtest.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class LoginSteps {

    WebDriver driver;

    @Given("user opens the login page")
    public void user_opens_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("User is not on dashboard", currentUrl.contains("inventory"));
        driver.quit();
    }
}