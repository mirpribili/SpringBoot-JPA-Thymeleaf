package com.javacorner.admin;


import com.javacorner.admin.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavacornerAdminApplication {

	/** Unit & Integration Testing Implementation Steps
	 * To take:
	 * 1. Use Spring Service Project.
	 * 2. Creating Unit Tests for Service Layer using Junit-5 & Mockito-4.
	 * 3. Configuring Test Containers for Integration Test.
	 * 4. Testing Repositories using TestContainers & DataJpaTest.
	 */

	public static void main(String[] args) {
		SpringApplication.run(JavacornerAdminApplication.class, args);
	}
}
