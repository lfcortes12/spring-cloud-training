package com.glb.training.bookstoreregistryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BookStoreRegistryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreRegistryServerApplication.class, args);
	}

}
