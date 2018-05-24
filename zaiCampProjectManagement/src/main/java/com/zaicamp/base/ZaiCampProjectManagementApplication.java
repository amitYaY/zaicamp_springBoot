package com.zaicamp.base;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.zaicamp.base.project.domain.CoffeeMachine;
import com.zaicamp.base.project.repos.CoffeeMachineRepository;
import com.zaicamp.base.project.util.constants.MachineStatus;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
@EntityScan(basePackages= {"com.zaicamp.base.project.domain"})
public class ZaiCampProjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZaiCampProjectManagementApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CoffeeMachineRepository repository) {
		return (args) -> {
			CoffeeMachine machine = new CoffeeMachine();
			machine.setStatus(MachineStatus.OFF.getStatus());
			repository.save(machine);
		};
	}
}
