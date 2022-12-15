package org.eugens21.user_interface.properties.browser.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@NoArgsConstructor(force = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Window {

    @NestedConfigurationProperty
    Position position;
    @NestedConfigurationProperty
    Dimension dimension;

}
