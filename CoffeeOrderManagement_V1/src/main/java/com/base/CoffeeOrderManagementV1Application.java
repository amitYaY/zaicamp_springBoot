package com.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

import com.base.domain.CoffeeMachine;
import com.base.service.impl.CoffeeMachineServiceImpl;
import com.base.util.constants.MachineStatus;

@SpringBootApplication
@EntityScan(basePackages = { "com.base.domain" })
public class CoffeeOrderManagementV1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CoffeeOrderManagementV1Application.class, args);

		CoffeeMachine machine = new CoffeeMachine();

		machine.setQuantityOfCoffeeBeans(10.0);
		machine.setQuantityOfMilk(15.0);
		machine.setQuantityOfWater(15.0);
		machine.setStatus(MachineStatus.ON.getStatus());
		
		CoffeeMachineServiceImpl machineServiceImpl = context.getBean(CoffeeMachineServiceImpl.class);
		machineServiceImpl.saveMachine(machine);
		
		Iterable<CoffeeMachine> machines = machineServiceImpl.getAllMachine();
		
		CoffeeMachine coffeeMachine = machines.iterator().next();
		
		coffeeMachine.setQuantityOfCoffeeBeans(15.0);
		coffeeMachine.setQuantityOfMilk(16.0);
		coffeeMachine.setQuantityOfWater(17.0);
		coffeeMachine.setStatus(MachineStatus.OFF.getStatus());
		
		machineServiceImpl.updateMachine(coffeeMachine);
	}

}
