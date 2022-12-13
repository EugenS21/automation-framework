package org.eugens21.testcontainers.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.testcontainers.config.storage.ScenarioContext;
import org.eugens21.testcontainers.config.storage.StorageKey;
import org.eugens21.testcontainers.service.Service;
import org.eugens21.user_interface.page.HomePage;
import org.eugens21.user_interface.page.home.HeaderPanel;
import org.eugens21.user_interface.page.home.LeftMenu;

import java.util.List;
import java.util.stream.Collectors;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Step extends BaseStep {

    Service service;
    HomePage homePage;
    ScenarioContext context;


    @Given("I am on home page")
    public void givenOnHomePage() {
        context.addValue(StorageKey.GENERIC, homePage);
    }

    @When("I wrote this")
    public void when() {
        System.out.println("@When(\"I wrote this\")\n");

    }

    @Then("you shout no")
    public void then() {
        System.out.println("@Then(\"you shout no\")\n");
    }

    @When("I check header panel content")
    public void iCheckHeaderFooterContent() {
        HeaderPanel headerPanel = homePage.getBody().getMainPanel().getHeaderPanel();
        context.addValue(StorageKey.GENERIC, headerPanel);
    }


    @And("I check left side menu bar")
    public void iCheckLeftSideMenuBar() {
        HeaderPanel value = context.getValue(StorageKey.GENERIC, HeaderPanel.class);
        LeftMenu leftMenu = value.getLeftMenu();
        context.addValue(StorageKey.GENERIC, leftMenu);
    }


    @Then("I should see the following items:")
    public void iShouldSeeTheFollowingItems(List<String> menus) {
        LeftMenu value = context.getValue(StorageKey.GENERIC, LeftMenu.class);
        List<String> collect = value.getItems()
                .stream()
                .map(el -> el.getText())
                .collect(Collectors.toList());
        menus.equals(collect);
    }
}
