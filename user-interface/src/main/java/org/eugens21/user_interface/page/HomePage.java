package org.eugens21.user_interface.page;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.eugens21.user_interface.page.home.Body;
import org.eugens21.user_interface.properties.PagesLocatorsProperties;
import org.eugens21.user_interface.properties.locators.home_page.HomePageDetails;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HomePage {

    WebDriver webDriver;
    HomePageDetails homePageDetails;
    @Getter
    @NonFinal
    Body body;

    @Autowired
    public HomePage(WebDriver webDriver, PagesLocatorsProperties pagesLocatorsProperties) {
        this.webDriver = webDriver;
        this.homePageDetails = pagesLocatorsProperties.getHome();
        this.webDriver.get(homePageDetails.getUrl());
    }

    @PostConstruct
    public void initializeElements() {
        this.body = new Body(webDriver, homePageDetails.getBody());
    }

    public void open() {
        if (!webDriver.getCurrentUrl().equals(homePageDetails.getUrl())) {
            webDriver.get(homePageDetails.getUrl());
        }
    }

}
