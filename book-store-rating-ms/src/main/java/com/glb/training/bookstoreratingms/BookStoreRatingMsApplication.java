package com.glb.training.bookstoreratingms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BookStoreRatingMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreRatingMsApplication.class, args);
	}

}
