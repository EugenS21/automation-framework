package org.eugens21.testcontainers.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.eugens21.testcontainers.TestContainersApplication;
import org.eugens21.user_interface.UserInterface;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@CucumberContextConfiguration
@SpringBootTest(classes = TestContainersApplication.class)
@Import({UserInterface.class})
public class CucumberSpringConfig {}
