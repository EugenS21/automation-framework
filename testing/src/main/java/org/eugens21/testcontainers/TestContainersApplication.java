package org.eugens21.testcontainers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties
@Configuration
@ComponentScan(basePackages = "org.eugens21.testcontainers.config")
public class TestContainersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestContainersApplication.class, args);
	}

}
