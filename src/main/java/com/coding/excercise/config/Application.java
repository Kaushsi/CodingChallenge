package com.coding.excercise.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"com.coding.excercise"})
public class Application {

	public static void main(String[] args) {
		
		System.getProperties().put( "server.port", 2080);
		new SpringApplicationBuilder() 
		.sources(Application.class)
		.run(args);
	}
}
