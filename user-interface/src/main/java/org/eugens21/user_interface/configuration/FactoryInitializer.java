package org.eugens21.user_interface.configuration;

import org.eugens21.user_interface.page.HomePage;
import org.junit.Rule;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.WaitAllStrategy;

import java.rmi.Remote;

@Configuration
public class FactoryInitializer {

    public RemoteWebDriver webDriver;
    public HomePage homePage;

}
