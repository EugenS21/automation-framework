package org.eugens21.user_interface.driver;

import io.vavr.control.Try;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.user_interface.properties.BrowserProperties;
import org.eugens21.user_interface.properties.WebDriverProperties;
import org.eugens21.user_interface.properties.browser.config.Position;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.util.Map;

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.SKIP;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@SuppressWarnings("rawtypes")
public class WebDriver {

    Boolean debug;
    BrowserProperties browserProperties;
    BrowserWebDriverContainer browserWebDriverContainer;
    WebDriverProperties webDriverProperties;

    @Autowired
    public WebDriver(BrowserProperties browserProperties, @Value(("${application.use-debug}")) Boolean debug, WebDriverProperties webDriverProperties) {
        this.debug = debug;
        this.browserProperties = browserProperties;
        this.browserWebDriverContainer = Try.withResources(BrowserWebDriverContainer::new)
                .of(e -> e.withCapabilities(browserProperties.getType()).withRecordingMode(SKIP, null))
                .getOrElseThrow(() -> new AssertionError("Unable to run container"));
        this.webDriverProperties = webDriverProperties;
    }

    @PostConstruct
    public void start() {
        if (!debug) {
            browserWebDriverContainer.start();
        }
    }

    @PreDestroy
    public void destroy() {
        if (!debug) {
            browserWebDriverContainer.stop();
        }
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
    public org.openqa.selenium.WebDriver driver() {
        if (debug) {
            return configureDriver(new ChromeDriver());
        }
        return configureDriver(new RemoteWebDriver(browserWebDriverContainer.getSeleniumAddress(), getCapabilities()));
    }

}
