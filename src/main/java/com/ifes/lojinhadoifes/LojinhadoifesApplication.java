package com.ifes.lojinhadoifes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "school",
		version = "1.0",
		description = "A Webservice about school"))
public class LojinhadoifesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojinhadoifesApplication.class, args);
	}

}
