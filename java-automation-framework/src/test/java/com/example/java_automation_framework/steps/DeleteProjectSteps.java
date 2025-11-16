package com.example.java_automation_framework.steps;

import com.example.java_automation_framework.driver.Context;
import com.example.java_automation_framework.pages.DeleteProjectPage;
import com.example.java_automation_framework.untils.SharedData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class DeleteProjectSteps {

    private final Context context;
    private DeleteProjectPage deleteProjectPage;

    public DeleteProjectSteps(Context context) {
        this.context = context;
    }

    @Given("Open Jira projects page")
    public void open_jira_projects_page() {
        deleteProjectPage = new DeleteProjectPage(context.getDriver());
    }

    @When("Click on the Move to Trash menu item")
    public void click_on_move_to_trash_menu_item() {
        deleteProjectPage.clickMoveToTrashActionForProject(SharedData.PROJECT_NAME);
        deleteProjectPage.clickMoveToTrashButton();
    }

    @And("Click on Move button")
    public void click_on_move_button() {
        deleteProjectPage.clickMoveButton();
        Assertions.assertFalse(deleteProjectPage.getSuccessMessageSpaceMovedSpan().isEmpty());
        deleteProjectPage.waitForMoveButtonDisappear();
        deleteProjectPage.enterSearchInput(SharedData.PROJECT_NAME);
        Assertions.assertFalse(deleteProjectPage.getNoSpacesFoundH2().isEmpty());
    }

    @And("Open Jira trash page")
    public void open_jira_trash_page() {
        deleteProjectPage.clickGoToTrashButton();
    }

    @And("Click on More Actions button of the deleted project")
    public void click_on_more_actions_button_of_deleted_project() {
        deleteProjectPage.clickPermanentDeleteActionForProject(SharedData.PROJECT_NAME);

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