package com.javacorner.admin;

import com.javacorner.admin.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavacornerAdminApplication implements CommandLineRunner {
	@Autowired
	private UserDao userDao;
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private InstructorDao instructorDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private RoleDao roleDao;

	/** Spring Service Implementation Steps
	 * To take:
	 * 1. Use Spring Data JPA project.
	 * 2. Remove Utility Package.
	 * 3. Create Service Interfaces & their implementations.
	 * 4. Add @Service & @Transactional Annotations to Services.
	 * 5. Update application.properties file.
	 * 6. Write from Application to Database & Test.
	 */

	public static void main(String[] args) {
		SpringApplication.run(JavacornerAdminApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
