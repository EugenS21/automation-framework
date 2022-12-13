package org.eugens21.user_interface;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.user_interface.properties.driver.Manage;
import org.eugens21.user_interface.properties.driver.WebDriverProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySources({@PropertySource("classpath:application.yml")})
@ConfigurationPropertiesScan("org.eugens21.user_interface.properties")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserInterface {}
