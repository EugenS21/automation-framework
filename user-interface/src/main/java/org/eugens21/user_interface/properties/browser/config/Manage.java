package org.eugens21.user_interface.properties.browser.config;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;


@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Manage {

    @NestedConfigurationProperty
    Timeouts timeouts;
    @NestedConfigurationProperty
    Window window;

}
