package com.backend.restoran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.backend.restoran")
public class RestoranApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestoranApplication.class, args);
	}
}
