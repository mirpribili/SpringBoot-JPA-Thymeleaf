package com.example.springbootv2713helloworldexample;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class SpringBootV2713HelloWorldExampleApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootV2713HelloWorldExampleApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(" *** Show arguments *** ");
		Arrays.stream(args.getSourceArgs()).forEach(System.out::println);
	}
}
