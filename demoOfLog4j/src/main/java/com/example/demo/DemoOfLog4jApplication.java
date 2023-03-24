package com.example.demo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoOfLog4jApplication {

	static Logger logger = Logger.getLogger(DemoOfLog4jApplication.class.getName());

	{
		BasicConfigurator.configure();
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoOfLog4jApplication.class, args);

		logger.trace("Trace log");
		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("Hey, This is a warning!");
		logger.error("Oops! We have an Error. OK");
		logger.fatal("Damn! Fatal error. Please fix me.");
	}

}
