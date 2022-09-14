package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ws.config.annotation.EnableWs;

@EnableWs
@SpringBootApplication
public class ServidorWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServidorWsApplication.class, args);
	}

}
