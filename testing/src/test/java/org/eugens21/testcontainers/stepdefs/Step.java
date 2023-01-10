package org.eugens21.testcontainers.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;
import org.eugens21.testcontainers.config.storage.ScenarioContext;
import org.eugens21.testcontainers.config.storage.StorageKey;
import org.eugens21.user_interface.object.HyperLink;
import org.eugens21.user_interface.page.HomePage;
import org.eugens21.user_interface.page.home.HeaderPanel;
import org.eugens21.user_interface.page.home.LeftMenu;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Step extends BaseStep {

    HomePage homePage;
    WebClient webClient;

    @Autowired
    public Step(SoftAssertions softAssertions, ModelMapper modelMap, HomePage homePage, ScenarioContext context, WebClient webClient) {
        super(softAssertions, modelMap, context);
        this.homePage = homePage;
        this.webClient = webClient;
    }

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
                .map(HyperLink::getText)
                .toList();
        softAssertions.assertThat(collect).containsExactlyInAnyOrderElementsOf(collect);
    }

    @When("I click on {string} menu item")
    public void iClickOnAboutUsMenuItem(String item) {
        LeftMenu value = context.getValue(StorageKey.GENERIC, LeftMenu.class);
        value.getItem(item).open();
    }

}
