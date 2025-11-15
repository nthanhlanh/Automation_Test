package com.example.java_automation_framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DeleteProjectPage {
    WebDriver driver;

    // Locators
    private final By moveToTrashButton = By.xpath("//button//div//span[normalize-space(text())='Move to trash']");
    private final By moveButton = By.xpath("//button//span[normalize-space(text())='Move']");
    private final By deleteNowButton = By.xpath("//button//div//span[normalize-space(text())='Delete now']");
    private final By deleteButton = By.xpath("//button//span[normalize-space(text())='Delete']");
    private final By searchInput = By.xpath("//input[@data-testid='searchfield']");
    private final By successMessageSpaceMovedSpan = By.xpath("//div/h2/span[text()='Space successfully moved to trash']");
    private final By successMessageSpaceDeletedSpan = By.xpath("//div/h2/span[text()='We’re deleting your space']");
    private final By moveProjectRows = By.xpath("//table[@class='css-wz0nuh']/tbody/tr");
    private final By projectTableRows = By.xpath("//table[@data-testid='inactive-projects.dynamic-table-stateless--table']/tbody/tr");
    private final By flagsSuccess = By.xpath("//*[@data-testid='project-permanent-delete-modal.ui.flags.success-flag-icon-container']");
    private final By goToTrashButton = By.xpath("//span[text()='Go to trash']");


    public DeleteProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void enterSearchInput(String key) {
        WebElement input = waitForElement(searchInput, 15);
        input.clear();
        input.sendKeys(key);
    }

    public void clickMoveToTrashButton() {
        waitForElement(moveToTrashButton, 15).click();
    }

    public void clickMoveButton() {
        waitForElement(moveButton, 3).click();
    }

    public void clickGoToTrashButton() {
        waitForElement(goToTrashButton, 3).click();
    }

    public void clickDeleteNowButtonButton() {
        waitForElement(deleteNowButton, 4).click();
    }

    public void clickDeleteButton() {
        waitForElement(deleteButton, 15).click();
    }

    public List<WebElement> getFlagsSuccess() {
       return waitForElement(flagsSuccess, 15).findElements(flagsSuccess);
    }

    public void clickMoveActionsByProjectName(String projectName) {
        List<WebElement> rows = waitForElement(moveProjectRows, 25).findElements(moveProjectRows);

        for (WebElement row : rows) {
            WebElement nameCell = row.findElement(By.xpath(".//td[2]//span"));
            if (nameCell.getText().trim().equals(projectName)) {
                WebElement actionBtn = row.findElement(By.xpath(".//td[6]//button"));
                actionBtn.click();
                break;
            }
        }
    }

    public void clickDeleteActionByProjectName(String projectName) {
        List<WebElement> rows = waitForElement(projectTableRows, 25).findElements(projectTableRows);

        for (WebElement row : rows) {
            WebElement nameCell = row.findElement(By.xpath(".//td[1]//span"));
            if (nameCell.getText().trim().equals(projectName)) {
                WebElement actionBtn = row.findElement(By.xpath(".//td[7]//button"));
                actionBtn.click();
                break;
            }
        }
    }

    public boolean isProjectPresentInTable(String projectName) {
        List<WebElement> rows = waitForElement(moveProjectRows, 25).findElements(moveProjectRows);

        for (WebElement row : rows) {
            WebElement nameCell = row.findElement(By.xpath(".//td[2]//span"));
            if (nameCell.getText().trim().equals(projectName)) {
                WebElement actionBtn = row.findElement(By.xpath(".//td[6]//button"));
                actionBtn.click();
                return true;
            }
        }

        return false;
    }


    public List<WebElement> getSuccessMessageSpaceMovedSpan(){
        return waitForElement(successMessageSpaceMovedSpan, 3).findElements(successMessageSpaceMovedSpan);
    }

    public List<WebElement> getSuccessMessageSpaceDeletedSpan(){
        return waitForElement(successMessageSpaceDeletedSpan, 3).findElements(successMessageSpaceDeletedSpan);
    }

}
