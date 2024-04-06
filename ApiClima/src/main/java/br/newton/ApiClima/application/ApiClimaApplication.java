package br.newton.ApiClima.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"br.newton"})
@EnableMongoRepositories("br.newton.ApiClima.repository")
public class ApiClimaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiClimaApplication.class, args);
    }

}
