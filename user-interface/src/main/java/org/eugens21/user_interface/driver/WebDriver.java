package org.eugens21.user_interface.driver;

import io.vavr.control.Try;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.user_interface.properties.browser.BrowserProperties;
import org.eugens21.user_interface.properties.driver.*;
import org.eugens21.user_interface.properties.locators.HomePageLocators;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.util.Map;

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.SKIP;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@SuppressWarnings("rawtypes")
public class WebDriver {

    BrowserProperties browserProperties;
    BrowserWebDriverContainer chrome;
    WebDriverProperties webDriverProperties;

    @Autowired
    public WebDriver(BrowserProperties browserProperties, WebDriverProperties webDriverProperties) {
        this.browserProperties = browserProperties;
        this.chrome = Try.withResources(BrowserWebDriverContainer::new)
                .of(e->e.withCapabilities(browserProperties.getType()).withRecordingMode(SKIP, null))
                .getOrElseThrow(() -> new AssertionError("Unable to run container"));
        this.webDriverProperties = webDriverProperties;
    }

    @PostConstruct
    public void start() {
        chrome.start();
    }

    @PreDestroy
    public void destroy() {
        chrome.stop();
    }

    private RemoteWebDriver configureDriver(RemoteWebDriver webDriver) {
        var manage = webDriverProperties.getManage();
        var timeouts = manage.getTimeouts();
        var window = manage.getWindow();
        var dimension = window.getDimension();
        webDriver.manage().timeouts().scriptTimeout(timeouts.getScriptTimeout());
        webDriver.manage().timeouts().pageLoadTimeout(timeouts.getPageLoadTimeout());
        webDriver.manage().timeouts().implicitlyWait(timeouts.getImplicitWait());
        Position position = window.getPosition();
        webDriver.manage().window().setSize(new Dimension(dimension.getLength(), dimension.getWidth()));
        webDriver.manage().window().setPosition(new Point(position.getX(), position.getY()));
        return webDriver;
    }

    private AbstractDriverOptions getCapabilities() {
        AbstractDriverOptions capabilities = browserProperties.getType();
        for (Map.Entry<String, Boolean> entry : browserProperties.getCapabilities().entrySet()) {
            capabilities.setCapability(entry.getKey(), entry.getValue());
        }
        return capabilities;
    }

    @Bean
    public org.openqa.selenium.WebDriver getDriver() {
        return configureDriver(new RemoteWebDriver(chrome.getSeleniumAddress(), getCapabilities()));
    }

}
