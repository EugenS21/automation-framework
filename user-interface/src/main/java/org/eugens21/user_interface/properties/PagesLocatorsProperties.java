package org.eugens21.user_interface.properties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.user_interface.properties.locators.home_page.HomePageDetails;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationProperties(prefix = "pages")
@ConfigurationPropertiesScan
public class PagesLocatorsProperties {

    @NestedConfigurationProperty
    HomePageDetails home;

}
