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
    private final By moveToTrashButton = By.xpath("//button[.//span[normalize-space(text())='Move to trash']]");
    private final By moveButton = By.xpath("//button[.//span[normalize-space(text())='Move']]");
    private final By deleteNowButton = By.xpath("//button[.//span[normalize-space(text())='Delete now']]");
    private final By deleteButton = By.xpath("//button[.//span[normalize-space(text())='Delete']]");
    private final By searchInput = By.xpath("//input[@type='text' and @data-test-id='searchfield']");
    private final By noSpacesFoundH2 = By.xpath("//h2[text()='No spaces were found that match your search']");
    private final By successMessageSpaceMovedSpan = By.xpath("//div/h2/span[text()='Space successfully moved to trash']");
    private final By successMessageSpaceDeletedSpan = By.xpath("//div/h2/span[text()='We’re deleting your space']");
    private final By activeProjectsTableRows = By.xpath("//table/tbody/tr");
    private final By trashProjectsTableRows = By.xpath("//table[@data-testid='inactive-projects.dynamic-table-stateless--table']/tbody/tr");
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
        WebElement input = waitForElement(searchInput, 25);
        input.clear();
        input.sendKeys(key);
    }

    public void clickMoveToTrashButton() {
        waitForElement(moveToTrashButton, 15).click();
    }

    public void clickMoveButton() {
        waitForElement(moveButton, 15).click();
    }

    public void clickGoToTrashButton() {
        waitForElement(goToTrashButton, 15).click();
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

    public void clickMoveToTrashActionForProject(String projectName) {
        List<WebElement> rows = waitForElement(activeProjectsTableRows, 25).findElements(activeProjectsTableRows);

        for (WebElement row : rows) {
            WebElement nameCell = row.findElement(By.xpath(".//td[2]//span"));
            if (nameCell.getText().trim().equals(projectName)) {
                WebElement actionBtn = row.findElement(By.xpath(".//td[6]//button"));
                actionBtn.click();
                break;
            }
        }
    }

    public void clickPermanentDeleteActionForProject(String projectName) {
        List<WebElement> rows = waitForElement(trashProjectsTableRows, 25).findElements(trashProjectsTableRows);

        for (WebElement row : rows) {
            WebElement nameCell = row.findElement(By.xpath(".//td[1]//span"));
            if (nameCell.getText().trim().equals(projectName)) {
                WebElement actionBtn = row.findElement(By.xpath(".//td[7]//button"));
                actionBtn.click();
                break;
            }
        }
    }

    public List<WebElement> getNoSpacesFoundH2(){
        return waitForElement(noSpacesFoundH2, 20).findElements(noSpacesFoundH2);
    }


    public List<WebElement> getSuccessMessageSpaceMovedSpan(){
        return waitForElement(successMessageSpaceMovedSpan, 10).findElements(successMessageSpaceMovedSpan);
    }

    public List<WebElement> getSuccessMessageSpaceDeletedSpan(){
        return waitForElement(successMessageSpaceDeletedSpan, 10).findElements(successMessageSpaceDeletedSpan);
    }

}
