package org.eugens21.testcontainers.config;

import lombok.val;
import org.assertj.core.api.SoftAssertions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Component
public class Initialize {

    @Bean
    public SoftAssertions softAssertions() {
        return new SoftAssertions();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        val configuration = modelMapper.getConfiguration();
        configuration.setFieldAccessLevel(PRIVATE);
        configuration.setFieldMatchingEnabled(true);
        configuration.setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }

}
