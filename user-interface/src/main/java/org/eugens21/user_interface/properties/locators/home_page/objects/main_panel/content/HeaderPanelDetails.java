package org.eugens21.user_interface.properties.locators.home_page.objects.main_panel.content;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class HeaderPanelDetails {

    By self;
    @NestedConfigurationProperty
    LeftMenuDetails leftMenu;

}
