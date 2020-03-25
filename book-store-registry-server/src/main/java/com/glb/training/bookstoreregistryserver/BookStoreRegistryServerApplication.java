package com.glb.training.bookstoreregistryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@EnableEurekaServer
@EnableConfigServer
@SpringBootApplication
public class BookStoreRegistryServerApplication {

	public static void main(final String[] args) {
		SpringApplication.run(BookStoreRegistryServerApplication.class, args);
	}

}
