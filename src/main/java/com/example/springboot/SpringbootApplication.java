package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.springboot.Entity")
public class SpringbootApplication {

	public static void main(String[] args) {


		SpringApplication.run(SpringbootApplication.class, args);
	}

}
