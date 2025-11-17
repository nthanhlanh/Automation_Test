package com.example.java_automation_framework.pages;

import com.example.java_automation_framework.untils.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CreateProjectPage {
    WebDriver driver;

    // Locators
    private final By createProjectButton = By.xpath("//button[@data-testid='global-pages.directories.projects-directory-v3.create-projects-button' and .//span[text()='Create space']]");
    private final By softwareDevMenu = By.xpath("//button[.//span[contains(text(),'Software development')]]");
    private final By scrumButton = By.xpath("//button[@aria-label='Scrum']");
    private final By useTemplateButton = By.xpath("//button[.//span[text()='Use template']]");
    private final By selectTeamManagedButton = By.xpath("//button[.//span[text()='Select a team-managed space']]");
    private final By nameInput = By.xpath("//input[@name='project-name']");
    private final By showMoreButton = By.xpath("//button[.//span//div[text()='Show more']]");
    private final By keyInput = By.xpath("//input[@name='key-field-project-create']");
    private final By nextButton = By.xpath("//button[.//span[text()='Next']]");
    private final By projectTableRows = By.xpath("//table[@class='css-wz0nuh']/tbody/tr");
    private final By headerBringYourTeamAlong = By.xpath("//h1[contains(text(), 'Bring your team along')]");
    private final By skipButton = By.xpath("//button[.//span[text()='Skip']]");
    private final By continueButton = By.xpath("//button[.//span[text()='Continue']]");
    private final By moreSpacesButton = By.xpath("//button[.//span[text()='More spaces']]");
    private final By viewAllSpacesLink = By.xpath("//a[.//span[text()='View all spaces']]");

    public CreateProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Actions
    public void clickCreateProjectButton() {
        waitForElement(createProjectButton, 25).click();
    }

    public void clickSoftwareDevMenu() {
        waitForElement(softwareDevMenu, 25).click();
    }

    public void clickScrumCard() {
        waitForElementToBeClickable(scrumButton, 35).click();
    }

    public void clickUseTemplate() {
        waitForElement(useTemplateButton, 25).click();
    }

    public void clickSelectTeamManaged() {
        waitForElement(selectTeamManagedButton, 25).click();
    }

    public void clickShowMoreButton() {
        waitForElement(showMoreButton, 25).click();
    }

    public void enterProjectName(String projectName) {
        WebElement input = waitForElement(nameInput, 25);
        input.clear();
        input.sendKeys(projectName);
    }

    public void enterProjectKey() {
        WebElement input = waitForElement(keyInput, 25);
        input.clear();
        input.sendKeys(RandomUtils.generateRandomProjectKey(8));
    }

    public void clickNextButton() {
        waitForElement(nextButton, 60).click();
    }

    public boolean isProjectPresentInTable(String projectName) {
        List<WebElement> rows = waitForElement(projectTableRows, 25).findElements(projectTableRows);

        for (WebElement row : rows) {
            WebElement nameCell = row.findElement(By.xpath(".//td[2]//span"));
            if (nameCell.getText().trim().equals(projectName)) {
                return true;
            }
        }

        return false;
    }

    public By getHeaderBringYourTeamAlongLocator(){
        return headerBringYourTeamAlong;
    }

    public void clickSkipButton() {
        waitForElement(skipButton, 25).click();
    }

    public void clickContinueButton() {
        waitForElement(continueButton, 25).click();
    }

    public void clickMoreSpacesButton() {
        waitForElement(moreSpacesButton, 25).click();
    }

    public void clickViewAllSpacesLink() {
        waitForElement(viewAllSpacesLink, 25).click();
    }

}
