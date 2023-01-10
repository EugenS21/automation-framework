package org.eugens21.testcontainers.config;

import lombok.val;
import org.assertj.core.api.SoftAssertions;
import org.eugens21.api.Rest;
import org.eugens21.user_interface.UserInterface;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Configuration
@Import({Rest.class, UserInterface.class})
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
