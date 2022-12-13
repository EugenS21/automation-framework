package org.eugens21.user_interface.properties.browser;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.user_interface.properties.browser.config.Manage;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "driver")
public class WebDriverProperties {

    @NestedConfigurationProperty
    Manage manage;

}
