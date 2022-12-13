package org.eugens21.user_interface.page.home;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.eugens21.user_interface.properties.locators.home_page.objects.footer_panel.FooterMainPanel;
import org.openqa.selenium.WebDriver;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FooterPanel {
    public FooterPanel(WebDriver webDriver, FooterMainPanel footerMainPanelDetails) {

    }
}
