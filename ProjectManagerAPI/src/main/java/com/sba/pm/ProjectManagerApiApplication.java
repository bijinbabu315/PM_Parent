package com.sba.pm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProjectManagerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagerApiApplication.class, args);
	}

}
