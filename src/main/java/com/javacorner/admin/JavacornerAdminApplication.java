package com.javacorner.admin;

import com.javacorner.admin.dao.*;
import com.javacorner.admin.entity.Course;
import com.javacorner.admin.entity.Instructor;
import com.javacorner.admin.entity.Student;
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
	@Bean
	CommandLineRunner start(UserService userService, RoleService roleService, StudentService studentService, InstructorService instructorService, CourseService courseService){
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


			Instructor instructor1 = instructorService.createInstructor("instructor1FN", "instructor1LN", "Experienced Instructor", "instructorUser1@gmai.com", "pass1");
			Instructor instructor2 = instructorService.createInstructor("instructor2FN", "instructor2LN", "Experienced Instructor", "instructorUser2@gmai.com", "pass2");

			Student student1 = studentService.createStudent("std1FN","std1LN","beginner","stdUser1@gmail.com","pass1");
			Student student2 = studentService.createStudent("std2FN","std2LN","master degree","stdUser2@gmail.com","pass2");

			Course course1 = courseService.createCourse("Spring Service", "2 Hours", "Master Spring Service", instructor1.getInstructorId());
			Course course2 = courseService.createCourse("Spring Data JPA", "4 Hours", "Introduction to JPA", instructor2.getInstructorId());

			courseService.assignStudentToCourse(course1.getCourseId(),student1.getStudentId());
			courseService.assignStudentToCourse(course2.getCourseId(),student1.getStudentId());
			courseService.assignStudentToCourse(course2.getCourseId(),student2.getStudentId());
		};
	}
}
