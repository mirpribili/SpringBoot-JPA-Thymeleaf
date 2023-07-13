package com.javacorner.admin;

import com.javacorner.admin.dao.*;
import com.javacorner.admin.entity.User;
import com.javacorner.admin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavacornerAdminApplication {
	public static final String ADMIN = "Admin";
	public static final String INSTRUCTOR = "Instructor";
	public static final String STUDENT = "Student";
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
	@Bean
	CommandLineRunner start(UserService userService, RoleService roleService, StudentService service, InstructorService instructorService, CourseService courseService){
		return args -> {
			User user1 = userService.createUser("user1@gmail.com", "pass1");
			User user2 = userService.createUser("user2@gmail.com", "pass2");
			User user3 = userService.createUser("user3@gmail.com", "pass3");

			roleService.createRole(ADMIN);
			roleService.createRole(INSTRUCTOR);
			roleService.createRole(STUDENT);

			userService.assignRoleToUser(user1.getEmail(), ADMIN);
			userService.assignRoleToUser(user2.getEmail(), INSTRUCTOR);
			userService.assignRoleToUser(user3.getEmail(), STUDENT);
		};
	}
}
