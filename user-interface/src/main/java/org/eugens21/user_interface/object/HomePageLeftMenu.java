package org.eugens21.user_interface.object;

import org.eugens21.user_interface.properties.locators.HomePageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HomePageLeftMenu implements Menu{

    WebDriver webDriver;
    @Autowired
    HomePageLocators homePageLocators;

    public HomePageLeftMenu(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void openElement(String element) {

    }

    @Override
    public List<WebElement> getList() {
        return null;
    }

}
