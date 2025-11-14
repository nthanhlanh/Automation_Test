package com.example.java_automation_framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public class CreateTask {
    WebDriver driver;

    private final UUID uuid = UUID.randomUUID();

    // Locators
    private final By createButton = By.xpath("//button[.//span[text()='Create']]");
    private final By summaryInput = By.xpath("//input[@id='summary-field' and @name='summary']");
    private final By assigneeMeButton  = By.xpath("//button[@data-testid='issue-create-commons.ui.assignee-field.assing-to-me-button']");
    private final By submitButton = By.xpath("//button[@data-testid='issue-create.common.ui.footer.create-button']");
    private final By viewTaskButton = By.xpath("//div//a[span[text()=\"View Task\"]]");



    public CreateTask(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement waitForElement(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void enterSummary(String summary) {
        waitForElement(summaryInput,4).sendKeys(getUniqueSummaryText(summary));
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

    public void clickViewTask() {
        waitForElement(viewTaskButton,4).click();
    }

    public List<WebElement> getSummary(String baseSummary){
        By uniqueSummaryLocator = getUniqueSummaryLocator(baseSummary);
        return waitForElement(uniqueSummaryLocator, 5).findElements(uniqueSummaryLocator);
    }

    private By getUniqueSummaryLocator(String baseSummary) {
        return By.xpath("//div//h1[normalize-space(text())='" + getUniqueSummaryText(baseSummary) + "']");
    }

    private String getUniqueSummaryText(String baseSummary) {
        return baseSummary + " " + uuid;
    }
}
