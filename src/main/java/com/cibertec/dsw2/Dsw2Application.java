package com.cibertec.dsw2;

import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableJpaAuditing
@SpringBootApplication
public class Dsw2Application {

	public static void main(String[] args) {
		SpringApplication.run(Dsw2Application.class, args);
	}

}
