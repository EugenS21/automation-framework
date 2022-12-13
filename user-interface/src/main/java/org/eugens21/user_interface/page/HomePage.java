package org.eugens21.user_interface.page;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.user_interface.object.HomePageLeftMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HomePage {

    HomePageLeftMenu menu;
    public HomePage(WebDriver webDriver) {
        this.menu = new HomePageLeftMenu(webDriver);
    }

}
