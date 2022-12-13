package org.eugens21.testcontainers.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.testcontainers.service.Service;
import org.eugens21.user_interface.driver.WebDriver;
import org.eugens21.user_interface.page.HomePage;
import org.springframework.beans.factory.annotation.Autowired;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Step extends BaseStep{

    Service service;
    WebDriver containers;

    @Given("we are in the room")
    public void given() {
        HomePage homePage = new HomePage(containers.getDriver());
    }

    @When("I wrote this")
    public void when() {
        System.out.println("@When(\"I wrote this\")\n");

    }

    @Then("you shout no")
    public void then() {
        System.out.println("@Then(\"you shout no\")\n");
    }

}
