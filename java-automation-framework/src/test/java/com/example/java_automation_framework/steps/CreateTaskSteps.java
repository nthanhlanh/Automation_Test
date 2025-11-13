package com.example.java_automation_framework.steps;

import com.example.java_automation_framework.pages.CreateTask;
import com.example.java_automation_framework.pages.LoginPage;
import com.example.java_automation_framework.support.Context;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTaskSteps {

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
        createTask.enterSummary("Automation Task "+ UUID.randomUUID());
        createTask.clickAssigneeMeButton();
    }

    @And("The user submits the task")
    public void the_user_submits_the_task() {
        createTask.clickSubmit();
    }

    @Then("The task is created successfully")
    public void then_title_is_displayed() {
    }
}