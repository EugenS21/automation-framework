package org.eugens21.api.client;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.api.properties.WebClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeFunctions;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class WebClientConfig {

    WebClientProperties webClientProperties;

    @Autowired
    public WebClientConfig(WebClientProperties webClientProperties) {
        this.webClientProperties = webClientProperties;
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(webClientProperties.getBaseUrl())
                .clientConnector(webClientProperties.getClientConnector())
                .exchangeStrategies(ExchangeStrategies.withDefaults())
                .exchangeFunction(ExchangeFunctions.create(new ReactorClientHttpConnector()))
                .build();
    }

}
