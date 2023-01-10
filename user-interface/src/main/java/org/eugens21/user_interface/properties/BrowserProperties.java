package org.eugens21.user_interface.properties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.util.Map;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "browser")
public class BrowserProperties {

    AbstractDriverOptions type;
    Map<String, Boolean> capabilities;

}
