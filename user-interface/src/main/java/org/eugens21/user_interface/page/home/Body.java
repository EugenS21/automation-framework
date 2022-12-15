package org.eugens21.user_interface.page.home;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.user_interface.object.Element;
import org.eugens21.user_interface.properties.locators.home_page.objects.BodyDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Body implements Element {

    WebElement self;
    @Getter
    MainPanel mainPanel;
    @Getter
    FooterPanel footerPanel;

    public Body(WebDriver webDriver, BodyDetails bodyDetails) {
        this.self = webDriver.findElement(bodyDetails.getSelf());
        this.footerPanel = new FooterPanel(webDriver, bodyDetails.getFooterMainPanel());
        this.mainPanel = new MainPanel(webDriver, bodyDetails.getMainPanel());
    }

    @Override
    public boolean isEnabled() {
        return self.isEnabled();
    }

    @Override
    public boolean isDisplayed() {
        return self.isDisplayed();
    }

}
