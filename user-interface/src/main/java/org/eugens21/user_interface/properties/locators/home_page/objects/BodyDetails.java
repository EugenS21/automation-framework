package org.eugens21.user_interface.properties.locators.home_page.objects;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.user_interface.properties.locators.home_page.objects.footer_panel.FooterMainPanel;
import org.eugens21.user_interface.properties.locators.home_page.objects.main_panel.MainPanelDetails;
import org.openqa.selenium.By;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@NoArgsConstructor(force = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class BodyDetails {

    By self;
    @NestedConfigurationProperty
    MainPanelDetails mainPanel;
    @NestedConfigurationProperty
    FooterMainPanel footerMainPanel;

}
