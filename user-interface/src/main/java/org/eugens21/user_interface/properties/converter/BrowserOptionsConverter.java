package org.eugens21.user_interface.properties.converter;

import org.eugens21.user_interface.enums.OptionsEnum;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class BrowserOptionsConverter implements Converter<String, AbstractDriverOptions> {

    @Override
    public AbstractDriverOptions convert(String browserType) {
        return OptionsEnum.valueOf(browserType.toUpperCase()).getDriverOptions();
    }
}
