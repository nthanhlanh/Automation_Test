package com.example.java_automation_framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateTask {
    WebDriver driver;

    // Locators
    private final By createButton = By.xpath("//button[.//span[text()='Create']]");
    private final By summaryInput = By.xpath("//input[@id='summary-field' and @name='summary']");
    private final By assigneeMeButton  = By.xpath("//button[@data-testid='issue-create-commons.ui.assignee-field.assing-to-me-button']");
    private final By submitButton = By.xpath("//button[@data-testid='issue-create.common.ui.footer.create-button']");

    public CreateTask(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement waitForElement(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void enterSummary(String summary) {
        waitForElement(summaryInput).sendKeys(summary);
    }

    public void clickCreate() {
        driver.findElement(createButton).click();
    }

    public void clickAssigneeMeButton() {
        driver.findElement(assigneeMeButton).click();
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
}
