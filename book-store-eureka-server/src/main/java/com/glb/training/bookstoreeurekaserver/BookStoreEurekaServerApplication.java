package com.glb.training.bookstoreeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BookStoreEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreEurekaServerApplication.class, args);
	}

}
