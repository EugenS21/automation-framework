package org.eugens21.user_interface.page.home;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.eugens21.user_interface.properties.locators.home_page.objects.main_panel.content.TopPanelDetails;
import org.openqa.selenium.WebDriver;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TopPanel {


    public TopPanel(WebDriver webDriver, TopPanelDetails topPanelDetails) {

    }
}
