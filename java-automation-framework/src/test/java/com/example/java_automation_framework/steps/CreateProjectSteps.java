package com.example.java_automation_framework.steps;

import com.example.java_automation_framework.driver.Context;
import com.example.java_automation_framework.pages.CreateProjectPage;
import com.example.java_automation_framework.untils.SharedData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class CreateProjectSteps {

    private final Context context;
    private CreateProjectPage createProjectPage;

    public CreateProjectSteps(Context context) {
        this.context = context;
    }

    @Given("I am on the Jira projects page")
    public void the_user_is_on_the_jira_projects_page() {
        createProjectPage = new CreateProjectPage(context.getDriver());
    }

    @When("I click on Create project button")
    public void the_user_clicks_create_project() {
        createProjectPage.clickCreateProjectButton();
    }

    @And("I click on Software development menu item")
    public void i_click_on_software_development_menu_item() {
        createProjectPage.clickSoftwareDevMenu();
    }

    @And("I click on Scrum card")
    public void i_click_on_scrum_card() {
        createProjectPage.clickScrumCard();
    }

    @And("I click on Use template button")
    public void i_click_on_use_template_button() {
        createProjectPage.clickUseTemplate();
    }

    @And("I click on Select a team managed project button")
    public void i_click_on_select_a_team_managed_project_button() {
        createProjectPage.clickSelectTeamManaged();
    }

    @And("I enter into the Name field")
    public void i_enter_into_the_name_field() {
        createProjectPage.enterProjectName(SharedData.PROJECT_NAME);
    }

    @And("I enter into the Key field")
    public void i_enter_into_the_key_field() {
        createProjectPage.clickShowMoreButton();
        createProjectPage.enterProjectKey();
        createProjectPage.clickNextButton();
        createProjectPage.waitForElement(createProjectPage.getHeaderBringYourTeamAlongLocator(),40);
        createProjectPage.clickSkipButton();
        createProjectPage.clickContinueButton();
        createProjectPage.clickMoreSpacesButton();
        createProjectPage.clickViewAllSpacesLink();
    }

    @Then("I should see the new project created successfully")
    public void i_should_see_the_new_project_created_successfully() {
        context.refreshDriver();
        Assertions.assertTrue(createProjectPage.isProjectPresentInTable(SharedData.PROJECT_NAME));
    }
}