package com.example.qatar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.example.qatar")
@ComponentScan(basePackages = {"com.example.qatar.service"})
public class Qatar2020Application {

	public static void main(String[] args) {
		SpringApplication.run(Qatar2020Application.class, args);
	}

}
