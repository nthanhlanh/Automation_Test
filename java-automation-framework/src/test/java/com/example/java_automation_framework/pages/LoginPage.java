package com.example.java_automation_framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class LoginPage {
    WebDriver driver;

    // Locators
    private final By usernameField = By.xpath("//input[@name='username']");
    private final By passwordField = By.xpath("//input[@name='password']");
    private final By continueButton = By.xpath("//button[@id='login-submit' and span[text()='Continue']]");
    private final By loginButton = By.xpath("//button[@id='login-submit' and span[text()='Log in']]");
    private final By titleText = By.xpath("//h1[@data-testid='home-header-content' and contains(normalize-space(), 'Hello')]");
    private final By jiraLink = By.xpath("//a[.//span[text()='Jira']]");
    private final By createProjectButton = By.xpath("//button[@data-testid='global-pages.directories.projects-directory-v3.create-projects-button' and .//span[text()='Create space']]");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void enterUsername(String username) {
        waitForElement(usernameField,15).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitForElement(passwordField,25).sendKeys(password);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
        waitForElement(titleText, 60);
    }

    public String getTitleText() {
        return waitForElement(titleText,1).getText();
    }

    public By getTitleLocator(){
        return titleText;
    }

    public void clickButtonOpenNewTab() {
        Set<String> originalHandles = driver.getWindowHandles();

        waitForElement(jiraLink,15).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.getWindowHandles().size() > originalHandles.size());

        Set<String> newHandles = driver.getWindowHandles();
        newHandles.removeAll(originalHandles);
        String newTab = newHandles.iterator().next();

        driver.close();

        driver.switchTo().window(newTab);
        waitForElement(createProjectButton, 30);
    }
}
