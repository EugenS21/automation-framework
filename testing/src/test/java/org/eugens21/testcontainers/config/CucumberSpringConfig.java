package org.eugens21.testcontainers.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.eugens21.testcontainers.TestContainersApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = TestContainersApplication.class)
public class CucumberSpringConfig {}
