package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FinalApplication {
	public static void main(String[] args) {

		try {
			SpringApplication.main(new String[]{""});
		}
		catch (Throwable ex){
			System.out.println(ex.getLocalizedMessage());
		}
		SpringApplication.run(FinalApplication.class, args);
	}
}
