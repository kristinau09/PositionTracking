package com.example.positionTracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PositionTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PositionTrackingApplication.class, args);
	}

}
