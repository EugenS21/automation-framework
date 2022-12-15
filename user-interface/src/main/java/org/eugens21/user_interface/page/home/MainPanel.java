package org.eugens21.user_interface.page.home;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.eugens21.user_interface.properties.locators.home_page.objects.main_panel.MainPanelDetails;
import org.openqa.selenium.WebDriver;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MainPanel {

    TopPanel topPanel;
    HeaderPanel headerPanel;

    public MainPanel(WebDriver webDriver, MainPanelDetails mainPanelDetails) {
        this.headerPanel = new HeaderPanel(webDriver, mainPanelDetails.getHeaderPanel());
        this.topPanel = new TopPanel(webDriver, mainPanelDetails.getTopPanel());
    }
}
