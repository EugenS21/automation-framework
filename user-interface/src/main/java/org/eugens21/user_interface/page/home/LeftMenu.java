package org.eugens21.user_interface.page.home;

import io.vavr.API;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.eugens21.user_interface.object.HyperLink;
import org.eugens21.user_interface.object.Menu;
import org.eugens21.user_interface.properties.locators.home_page.objects.main_panel.content.LeftMenuDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static java.util.List.of;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LeftMenu implements Menu<HyperLink> {

    WebElement self;
    HyperLink solutions;
    HyperLink aboutUs;
    HyperLink services;
    HyperLink products;
    HyperLink locations;
    HyperLink adminPage;

    public LeftMenu(WebDriver webDriver, LeftMenuDetails leftMenuDetails) {
        this.self = webDriver.findElement(leftMenuDetails.getSelf());
        this.solutions = new HyperLink(webDriver, leftMenuDetails.getSolutions());
        this.aboutUs = new HyperLink(webDriver, leftMenuDetails.getAboutUs());
        this.services = new HyperLink(webDriver, leftMenuDetails.getServices());
        this.products = new HyperLink(webDriver, leftMenuDetails.getProducts());
        this.locations = new HyperLink(webDriver, leftMenuDetails.getLocations());
        this.adminPage = new HyperLink(webDriver, leftMenuDetails.getAdminPage());
    }

    @Override
    public List<HyperLink> getItems() {
        return of(solutions, aboutUs, services, products, locations, adminPage);
    }

    @Override
    public HyperLink getItem(String name) {
        return API.Match(name).of(
                Case($("solutions"), solutions),
                Case($("aboutUs"), aboutUs),
                Case($("services"), services),
                Case($("products"), products),
                Case($("locations"), locations),
                Case($(), adminPage)
        );
    }

}
