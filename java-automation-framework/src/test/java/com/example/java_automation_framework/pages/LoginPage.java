package com.example.java_automation_framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    // Locators
    private final By usernameField = By.xpath("//input[@name='username']");
    private final By passwordField = By.xpath("//input[@name='password']");
    private final By continueButton = By.xpath("//button[@id='login-submit' and span[text()='Continue']]");
    private final By loginButton = By.xpath("//button[@id='login-submit' and span[text()='Log in']]");
    private final By titleText = By.xpath("//h1[text()='For you']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement waitForElement(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void enterUsername(String username) {
        waitForElement(usernameField,4).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitForElement(passwordField,4).sendKeys(password);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
        waitForElement(titleText, 40);
    }

    public String getTitleText() {
        return waitForElement(titleText,1).getText();
    }
}
