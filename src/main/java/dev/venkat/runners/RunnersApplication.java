package dev.venkat.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnersApplication {

	private static final Logger logger = LoggerFactory.getLogger(RunnersApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(RunnersApplication.class, args);
		logger.info("Runners Application started.");
	}
}
