package com.zaicamp.base;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
@EntityScan(basePackages= {"com.zaicamp.base.project.domain"})
public class ZaiCampProjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZaiCampProjectManagementApplication.class, args);
	}
}
