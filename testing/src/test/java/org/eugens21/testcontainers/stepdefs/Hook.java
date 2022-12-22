package org.eugens21.testcontainers.stepdefs;

import io.cucumber.java.After;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Hook {
    SoftAssertions softAssertions;
    WebDriver webDriver;


    @After
    public void doAssertAll() {
        softAssertions.assertAll();
    }

}
