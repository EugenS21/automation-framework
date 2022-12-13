package org.eugens21.user_interface.properties.driver;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "driver")
public class WebDriverProperties {

    @NestedConfigurationProperty
    private Manage manage;

}
