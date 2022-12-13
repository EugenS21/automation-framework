package org.eugens21.user_interface.properties.browser;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

@Data
@Validated
@NoArgsConstructor
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "browser")
public class BrowserProperties {

    AbstractDriverOptions type;
    Map<String, Boolean> capabilities;

}
