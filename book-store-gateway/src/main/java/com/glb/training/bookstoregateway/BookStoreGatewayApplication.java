package com.glb.training.bookstoregateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableZuulProxy
@SpringBootApplication
public class BookStoreGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreGatewayApplication.class, args);
	}

}
