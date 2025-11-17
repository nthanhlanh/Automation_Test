package com.example.java_automation_framework.steps;

import com.example.java_automation_framework.config.ConfigLoader;
import com.example.java_automation_framework.config.AppConfig;
import com.example.java_automation_framework.pages.CreateTaskPage;
import com.example.java_automation_framework.driver.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class CreateTaskSteps {

    private final String baseSummary = "Automation Task";

    private final Context context;
    private CreateTaskPage createTaskPage;
    private final AppConfig config;

    public CreateTaskSteps(Context context) {
        this.context = context;
        this.config = ConfigLoader.getInstance().getConfig();
    }

    @Given("The user is on the dashboard")
    public void the_user_is_on_the_login_page() {
        createTaskPage = new CreateTaskPage(context.getDriver());
    }

    @When("The user clicks Create Task")
    public void the_user_clicks_task() {
        createTaskPage.clickRowByProjectName(config.getTaskProjectName());
        createTaskPage.clickCreate();
    }

    @And("The user fills task details")
    public void the_user_fill_task_details() {
        createTaskPage.enterSummary(baseSummary);
        createTaskPage.clickAssigneeMeButton();
    }

    @And("The user submits the task")
    public void the_user_submits_the_task() {
        createTaskPage.clickSubmit();
    }

    @Then("The task is created successfully")
    public void the_task_is_created_successfully() {
        createTaskPage.clickViewTask();
        Assertions.assertFalse(createTaskPage.getSummary(baseSummary).isEmpty());
    }
}