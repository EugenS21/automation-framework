package org.eugens21.user_interface.properties.locators.home_page.objects.main_panel;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.user_interface.properties.locators.home_page.objects.main_panel.content.HeaderPanelDetails;
import org.eugens21.user_interface.properties.locators.home_page.objects.main_panel.content.TopPanelDetails;
import org.openqa.selenium.By;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@NoArgsConstructor(force = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class MainPanelDetails {

    By self;
    @NestedConfigurationProperty
    TopPanelDetails topPanel;
    @NestedConfigurationProperty
    HeaderPanelDetails headerPanel;

}
