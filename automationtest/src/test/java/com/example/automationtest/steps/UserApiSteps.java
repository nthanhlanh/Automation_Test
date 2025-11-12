package com.example.automationtest.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserApiSteps {

    private Response response;
    private final String BASE_URL = "http://localhost:8089";

    @Given("the user API is running")
    public void theUserApiIsRunning() {
        // Bạn có thể ping server hoặc chỉ cần log
        System.out.println("Checking if API is running on " + BASE_URL);
    }

    @When("I send a GET request to {string}")
    public void iSendAGETRequestTo(String endpoint) {
        response = given()
                        .when()
                        .get(BASE_URL + endpoint)
                        .then()
                        .extract()
                        .response();
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int statusCode) {
        assertThat(response.statusCode(), is(statusCode));
    }

    @Then("the response should contain {int} users")
    public void theResponseShouldContainUsers(int count) {
        assertThat(response.jsonPath().getList("$"), hasSize(count));
    }

    @Then("the first user should have name {string}")
    public void theFirstUserShouldHaveName(String expectedName) {
        String actualName = response.jsonPath().getString("[0].name");
        assertThat(actualName, equalTo(expectedName));
    }

    @Then("the response should contain user with id {string}")
    public void theResponseShouldContainUserWithId(String id) {
        int actualId = response.jsonPath().getInt("id");
        assertThat(actualId, is(Integer.parseInt(id)));
    }

    @Then("the response should have correct name {string} and email {string}")
    public void theResponseShouldHaveCorrectNameAndEmail(String name, String email) {
        String actualName = response.jsonPath().getString("name");
        String actualEmail = response.jsonPath().getString("email");

        assertThat(actualName, is(name));
        assertThat(actualEmail, is(email));
    }
}