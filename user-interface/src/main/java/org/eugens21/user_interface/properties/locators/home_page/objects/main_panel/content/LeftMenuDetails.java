package org.eugens21.user_interface.properties.locators.home_page.objects.main_panel.content;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class LeftMenuDetails {

    By self;
    By solutions;
    By aboutUs;
    By services;
    By products;
    By locations;
    By adminPage;

}
