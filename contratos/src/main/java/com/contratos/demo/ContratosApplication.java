package com.contratos.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.contratos.demo")
public class ContratosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContratosApplication.class, args);
	}

}
