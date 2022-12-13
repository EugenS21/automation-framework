package org.eugens21.user_interface.properties.driver;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.boot.context.properties.bind.Nested;
import org.springframework.stereotype.Component;



@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Manage {

    @NestedConfigurationProperty
    Timeouts timeouts;
    @NestedConfigurationProperty
    Window window;

}
