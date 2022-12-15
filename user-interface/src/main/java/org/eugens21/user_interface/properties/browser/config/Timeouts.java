package org.eugens21.user_interface.properties.browser.config;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Duration;

@NoArgsConstructor(force = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Timeouts {

    Duration implicitWait;
    Duration pageLoadTimeout;
    Duration scriptTimeout;

}
