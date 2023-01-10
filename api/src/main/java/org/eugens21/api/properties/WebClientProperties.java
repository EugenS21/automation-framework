package org.eugens21.api.properties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.http.client.reactive.ClientHttpConnector;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "client")
public class WebClientProperties {

    String baseUrl;
    ClientHttpConnector clientConnector;

}
