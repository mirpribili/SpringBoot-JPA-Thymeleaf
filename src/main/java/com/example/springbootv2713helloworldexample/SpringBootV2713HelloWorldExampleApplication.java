package com.example.springbootv2713helloworldexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class SpringBootV2713HelloWorldExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootV2713HelloWorldExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(" *** Show arguments *** ");
		Arrays.stream(args).forEach(System.out::println);
	}
/*
if I want war file
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return super.configure(builder);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootV2713HelloWorldExampleApplication.class, args);
	}
* */
}
