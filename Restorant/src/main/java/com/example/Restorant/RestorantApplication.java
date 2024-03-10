package com.example.Restorant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class RestorantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestorantApplication.class, args);
	}

}
