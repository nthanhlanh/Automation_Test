package com.example.java_automation_framework.pages;

import com.example.java_automation_framework.untils.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

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
    private final By moveProjectRows = By.xpath("//table[@class='css-wz0nuh']/tbody/tr");

    public CreateProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement waitForElement(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Actions
    public void clickCreateProjectButton() {
        waitForElement(createProjectButton, 4).click();
    }

    public void clickSoftwareDevMenu() {
        waitForElement(softwareDevMenu, 6).click();
    }

    public void clickScrumCard() {
        waitForElement(scrumButton, 5).click();
    }

    public void clickUseTemplate() {
        waitForElement(useTemplateButton, 1).click();
    }

    public void clickSelectTeamManaged() {
        waitForElement(selectTeamManagedButton, 1).click();
    }

    public void clickShowMoreButton() {
        waitForElement(showMoreButton, 1).click();
    }

    public void enterProjectName(String projectName) {
        WebElement input = waitForElement(nameInput, 1);
        input.clear();
        input.sendKeys(projectName);
    }

    public void enterProjectKey() {
        WebElement input = waitForElement(keyInput, 1);
        input.clear();
        input.sendKeys(RandomUtils.generateRandomProjectKey(8));
    }

    public void clickNextButton() {
        waitForElement(nextButton, 60).click();
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

}
