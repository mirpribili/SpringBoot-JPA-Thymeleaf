package com.javacorner.admin.utility;

import com.javacorner.admin.dao.InstructorDao;
import com.javacorner.admin.dao.RoleDao;
import com.javacorner.admin.dao.StudentDao;
import com.javacorner.admin.dao.UserDao;
import com.javacorner.admin.entity.Instructor;
import com.javacorner.admin.entity.Role;
import com.javacorner.admin.entity.Student;
import com.javacorner.admin.entity.User;

import javax.persistence.EntityNotFoundException;
import java.util.List;


public class OperationUtility {
    public static void userOperations(UserDao userDao){
        createUsers(userDao);
        updateUser(userDao);
        deleteUser(userDao);
        fetchUsers(userDao);
    }

    public static void roleOperations(RoleDao roleDao){
        createRoles(roleDao);
        updateRole(roleDao);
        deleteRole(roleDao);
        fetchRole(roleDao);
    }

    public static void instructorsOperations(UserDao userDao, InstructorDao instructorDao, RoleDao roleDao){
        createInstructors(userDao, instructorDao, roleDao);
        updateInstructor(instructorDao);
        deleteInstructor(instructorDao);
        fetchInstructors(instructorDao);
    }

    public static void studentOperations(UserDao userDao, StudentDao studentDao, RoleDao roleDao){
        createStudents(userDao, studentDao, roleDao);
        updateStudent(studentDao);
        deleteStudent(studentDao);
        fetchStudents(studentDao);
    }

    private static void fetchStudents(StudentDao studentDao) {
        studentDao.findAll().forEach(student -> System.out.println(student.toString()));
    }

    private static void deleteStudent(StudentDao studentDao) {
        studentDao.deleteById(1L);
    }

    private static void updateStudent(StudentDao studentDao) {
        Student student = studentDao.findById(1L).orElseThrow(()-> new EntityNotFoundException("Student Not Found"));
        student.setFirstName("updatedStdFN");
        student.setLastName("updatedStdLN");
        studentDao.save(student);
    }

    private static void createStudents(UserDao userDao, StudentDao studentDao, RoleDao roleDao) {
        Role role = roleDao.findByName("Student");
        if(role==null) throw new EntityNotFoundException("Role Not Found");
        User user1 = new User("stdUser1@gmail.com", "pass1");
        userDao.save(user1);
        user1.assignRoleToUser(role);
        Student student1 = new Student("student1Fn", "student1LN", "master", user1);
        studentDao.save(student1);

        User user2 = new User("stdUser2@gmail.com", "pass2");
        userDao.save(user2);
        user2.assignRoleToUser(role);
        Student student2 = new Student("student2Fn", "student2LN", "Phd", user2);
        studentDao.save(student2);
    }

    public static void assignRolesToUsers(UserDao userDao, RoleDao roleDao){
        Role role = roleDao.findByName("Admin");
        if(role==null) throw new EntityNotFoundException("Role Not Found");
        List<User> users = userDao.findAll();
        users.forEach(user ->{
            user.assignRoleToUser(role);
            userDao.save(user);
                });
    }

    private static void fetchRole(RoleDao roleDao) {
        roleDao.findAll().forEach(role -> System.out.println(role.toString()));
    }

    private static void deleteRole(RoleDao roleDao) {
        //not need:  Role role = roleDao.findById(2L).orElseThrow(()-> new EntityNotFoundException("Role Not Found"));
        // see ctrl+alt+B
        roleDao.deleteById(2L);
    }

    public static void updateRole(RoleDao roleDao){
        Role role = roleDao.findById(1L).orElseThrow(()-> new EntityNotFoundException("Role Not Found"));
        role.setName("NewAdmin");
        roleDao.save(role);
    }
    public static void createRoles(RoleDao roleDao){
        Role role1 = new Role("Admin");
        roleDao.save(role1);
        Role role2 = new Role("Instructor");
        roleDao.save(role2);
        Role role3 = new Role("Student");
        roleDao.save(role3);
    }
    public static void createUsers(UserDao userDao){
        User user1 = new User("user1@gmail.com", "pass1");
        userDao.save(user1);
        User user2 = new User("user2@gmail.com", "pass2");
        userDao.save(user2);
        User user3 = new User("user3@gmail.com", "pass3");
        userDao.save(user3);
        User user4 = new User("user4@gmail.com", "pass4");
        userDao.save(user4);
    }

    public static void updateUser(UserDao userDao){
        User user = userDao.findById(2L).orElseThrow(()->new EntityNotFoundException("User Not Found"));
        user.setEmail("newEmail@gmail.com");
        userDao.save(user);
    }
    public static void deleteUser(UserDao userDao){
        User user = userDao.findById(3L).orElseThrow(()->new EntityNotFoundException("User Not Found"));
        userDao.delete(user);
    }
    public static void fetchUsers(UserDao userDao){
        userDao.findAll().forEach(user -> System.out.println(user.toString()));
    }



    private static void fetchInstructors(InstructorDao instructorDao) {
        instructorDao.findAll().forEach(instructor -> System.out.println(instructor.toString()));
    }

    private static void deleteInstructor(InstructorDao instructorDao) {
        instructorDao.deleteById(2L);
    }

    private static void updateInstructor(InstructorDao instructorDao) {
        Instructor instructor = instructorDao.findById(1L).orElseThrow(
                ()->new EntityNotFoundException("Instructor Not Found"));
        instructor.setSummary("Certified Instructor");
        instructorDao.save(instructor);
    }

    private static void createInstructors(UserDao userDao, InstructorDao instructorDao, RoleDao roleDao) {
        Role role = roleDao.findByName("Instructor");
        if(role == null) throw new EntityNotFoundException("Role Not Found");

        User user1 = new User("InstructorUser1@gmail.com", "pass1");
        userDao.save(user1);
        user1.assignRoleToUser(role);
        Instructor instructor1 =new Instructor(
                "instructor1FN", "instructor1LN", "Experienced Instructor", user1);
        instructorDao.save(instructor1);

        User user2 = new User("InstructorUser2@gmail.com", "pass2");
        userDao.save(user2);
        user2.assignRoleToUser(role);
        Instructor instructor2 =new Instructor(
                "instructor2FN", "instructor2LN", "Senior Instructor", user2);
        instructorDao.save(instructor2);
    }
}
