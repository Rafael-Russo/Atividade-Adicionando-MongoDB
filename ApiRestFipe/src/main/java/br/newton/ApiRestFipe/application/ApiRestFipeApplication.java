package br.newton.ApiRestFipe.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"br.newton"})
@EnableMongoRepositories("br.newton.ApiRestFipe.repository")
public class ApiRestFipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestFipeApplication.class, args);
	}

}
