package com.example.java_automation_framework.steps;

import com.example.java_automation_framework.pages.CreateTask;
import com.example.java_automation_framework.support.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class CreateTaskSteps {

    private final String BASE_SUMMARY = "Automation Task";

    private final Context context;
    private CreateTask createTask;

    public CreateTaskSteps(Context context) {
        this.context = context;
    }

    @Given("The user is on the dashboard")
    public void the_user_is_on_the_login_page() {
        createTask = new CreateTask(context.getDriver());
    }

    @When("The user clicks Create Task")
    public void the_user_clicks_task() {
        createTask.clickCreate();
    }

    @And("The user fills task details")
    public void the_user_fill_task_details() {
        createTask.enterSummary(BASE_SUMMARY);
        createTask.clickAssigneeMeButton();
    }

    @And("The user submits the task")
    public void the_user_submits_the_task() {
        createTask.clickSubmit();
    }

    @Then("The task is created successfully")
    public void the_task_is_created_successfully() {
        createTask.clickViewTask();
        Assertions.assertFalse(createTask.getSummary(BASE_SUMMARY).isEmpty());
    }
}