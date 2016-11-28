package com.epam.amatias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class CloudHashmapApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudHashmapApplication.class, args);
	}

	@Bean
	TrivialStringHashMap getMap() {
		return new TrivialStringHashMap();
	}
}
