package org.eugens21.user_interface;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@ConfigurationPropertiesScan(basePackages = "org.eugens21.user_interface.properties")
public class UserInterface {}
