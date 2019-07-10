package com.glb.training.bookstorems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableDiscoveryClient
@SpringBootApplication
public class BookStoreMsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreMsApplication.class, args);
	}

}
