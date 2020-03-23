package com.glb.training.bookstoregateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableHystrixDashboard
@EnableTurbine
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class BookStoreGatewayApplication {

	public static void main(final String[] args) {
		SpringApplication.run(BookStoreGatewayApplication.class, args);
	}

}
