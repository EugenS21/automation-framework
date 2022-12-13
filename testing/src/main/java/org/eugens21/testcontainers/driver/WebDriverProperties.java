package org.eugens21.testcontainers.driver;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "driver")
public class WebDriverProperties {
}
