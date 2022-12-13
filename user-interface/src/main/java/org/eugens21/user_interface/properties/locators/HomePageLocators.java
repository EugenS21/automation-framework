package org.eugens21.user_interface.properties.locators;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@PropertySources({@PropertySource("classpath:user_interface.properties")})
public class HomePageLocators {

    @Getter
    @Value("${home_page}")
    private String homePage;



}
