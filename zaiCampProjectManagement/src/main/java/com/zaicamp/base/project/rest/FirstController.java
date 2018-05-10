package com.zaicamp.base.project.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/project")
public class FirstController {
	
	Logger logger = LoggerFactory.getLogger(FirstController.class);
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String showWelcomeMessage() {
		return "Hello World!";
	}

}
