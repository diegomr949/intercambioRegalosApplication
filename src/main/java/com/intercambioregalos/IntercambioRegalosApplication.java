package com.intercambioregalos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntercambioRegalosApplication {

	public static void main(String[] args) {

		SpringApplication.run(IntercambioRegalosApplication.class, args);
		System.out.println("API de intercambio de regalos iniciada");
	}

}
