package org.eugens21.user_interface.properties.locators.home_page;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.user_interface.properties.locators.home_page.objects.BodyDetails;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomePageDetails {

    String url;
    @NestedConfigurationProperty
    BodyDetails body;


}
