package org.eugens21.api.properties.web_client.converter;

import io.vavr.API;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.JettyClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;

import static io.vavr.API.Case;
import static io.vavr.API.Match;

@Component
@ConfigurationPropertiesBinding
public class WebClientConverter implements Converter<String, ClientHttpConnector> {

    @Override
    public ClientHttpConnector convert(String source) {
        return Match(source).of(
                Case(API.$("JettyClientHttpConnector"), () -> new JettyClientHttpConnector()),
                Case(API.$(), () -> new ReactorClientHttpConnector())
        );
    }

}
