package com.springguru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
//@ComponentScans(@ComponentScan(basePackages = {"com.springguru.bootStrap","com.springguru.repository",
	//	                                       "com.springguru.mbo"}))
public class TrainingSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingSiteApplication.class, args);
	}

}
