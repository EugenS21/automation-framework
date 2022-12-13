package org.eugens21.user_interface.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum OptionsEnum {

    FIREFOX(new FirefoxOptions()),
    CHROME(new ChromeOptions()),
    INTERNET_EXPLORER(new InternetExplorerOptions()),
    EDGE(new EdgeOptions());

    @Getter
    AbstractDriverOptions driverOptions;

}
