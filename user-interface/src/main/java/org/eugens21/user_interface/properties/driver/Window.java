package org.eugens21.user_interface.properties.driver;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.time.Duration;

@NoArgsConstructor(force = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Window {

    @NestedConfigurationProperty
    Position position;
    @NestedConfigurationProperty
    Dimension dimension;

}
