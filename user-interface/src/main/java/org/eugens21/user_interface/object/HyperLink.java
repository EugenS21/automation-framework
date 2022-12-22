package org.eugens21.user_interface.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HyperLink implements Href {

    WebElement webElement;

    public HyperLink(WebDriver webDriver, By details) {
        this.webElement = webDriver.findElement(details);
    }

    @Override
    public void open() {
        webElement.click();
    }

    @Override
    public String getAddress() {
        return webElement.getAttribute("href");
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

}
