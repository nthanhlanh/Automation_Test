package com.example.java_automation_framework.steps;

import com.example.java_automation_framework.config.ConfigLoader;
import com.example.java_automation_framework.config.AppConfig;
import com.example.java_automation_framework.driver.Context;
import com.example.java_automation_framework.pages.DeleteProjectPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class DeleteProjectSteps {

    private final Context context;
    private DeleteProjectPage deleteProjectPage;
    private final AppConfig config;

    public DeleteProjectSteps(Context context) {
        this.context = context;
        this.config = ConfigLoader.getInstance().getConfig();
    }

    @Given("Open Jira projects page")
    public void open_jira_projects_page() {
        deleteProjectPage = new DeleteProjectPage(context.getDriver());
    }

    @When("Click on the Move to Trash menu item")
    public void click_on_move_to_trash_menu_item() {
        deleteProjectPage.clickMoveToTrashActionForProject(config.getProjectName());
        deleteProjectPage.clickMoveToTrashButton();
    }

    @And("Click on Move button")
    public void click_on_move_button() {
        deleteProjectPage.clickMoveButton();
        Assertions.assertFalse(deleteProjectPage.getSuccessMessageSpaceMovedSpan().isEmpty());
        deleteProjectPage.waitForMoveButtonDisappear();
        deleteProjectPage.enterSearchInput(config.getProjectName());
        Assertions.assertFalse(deleteProjectPage.getNoSpacesFoundH2().isEmpty());
    }

    @And("Open Jira trash page")
    public void open_jira_trash_page() {
        deleteProjectPage.clickGoToTrashButton();
    }

    @And("Click on More Actions button of the deleted project")
    public void click_on_more_actions_button_of_deleted_project() {
        deleteProjectPage.clickPermanentDeleteActionForProject(config.getProjectName());

    }

    @And("Click on Delete now menu item")
    public void click_on_delete_now_menu_item() {
        deleteProjectPage.clickDeleteNowButtonButton();
    }

    @And("Click on Delete button")
    public void click_on_delete_button() {
        deleteProjectPage.clickDeleteButton();
    }

    @Then("the project should be permanently deleted")
    public void the_project_should_be_permanently_deleted() {
        deleteProjectPage.getFlagsSuccess();
        Assertions.assertFalse(deleteProjectPage.getFlagsSuccess().isEmpty());
        Assertions.assertFalse(deleteProjectPage.getSuccessMessageSpaceDeletedSpan().isEmpty());
    }
}