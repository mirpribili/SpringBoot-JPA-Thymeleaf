package com.example.springbootv2713helloworldexample;

import com.example.springbootv2713helloworldexample.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class SpringBootV2713HelloWorldExampleApplication implements CommandLineRunner {
	@Autowired
	private ConfigProperties configProperties;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootV2713HelloWorldExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(" *** mail properties *** ");
		System.out.println("from:"+configProperties.getFrom());
		System.out.println("to:"+configProperties.getTo());
		System.out.println("default object:"+configProperties.getDefaultObject());
	}
}
