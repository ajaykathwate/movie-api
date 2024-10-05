package com.movieapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieApiApplication {
	@Value("${spring.datasource.username}")
	private static String name;

	public static void main(String[] args) {
		SpringApplication.run(MovieApiApplication.class, args);
	}

}
