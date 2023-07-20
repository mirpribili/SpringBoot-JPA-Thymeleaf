package com.javacorner.admin.web;

import com.javacorner.admin.entity.Course;
import com.javacorner.admin.entity.Instructor;
import com.javacorner.admin.service.CourseService;
import com.javacorner.admin.service.InstructorService;
import com.javacorner.admin.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import static com.javacorner.admin.constants.JavaCornerConstants.*;

@Controller
@RequestMapping(value = "/courses")
public class CourseController {

    private CourseService courseService;

    private InstructorService instructorService;
    private UserService userService;

    public CourseController(CourseService courseService, InstructorService instructorService, UserService userService) {
        this.courseService = courseService;
        this.instructorService = instructorService;
        this.userService = userService;
    }

    //@ResponseBody
    @GetMapping(value = "/index")
    // only for admin role
    @PreAuthorize("hasAuthority('Admin')")
    public String courses(Model model, @RequestParam(name = KEYWORD, defaultValue = "") String keyword) {
        List<Course> courses = courseService.findCoursesByCourseName(keyword);
        model.addAttribute(LIST_COURSES, courses);
        model.addAttribute(KEYWORD, keyword);
        return "course-views/courses";
    }

    @GetMapping(value = "/delete")
    @PreAuthorize("hasAuthority('Admin')")
    public String deleteCourse(Long courseId, String keyword) {
        courseService.removeCourse(courseId);
        return "redirect:/courses/index?keyword=" + keyword;
    }

    @GetMapping(value = "/formUpdate")
    @PreAuthorize("hasAnyAuthority('Admin','Instructor')")
    public String updateCourse(Model model, Long courseId, Principal principal) {
        if (userService.doesCurrentUserHasRole(INSTRUCTOR)) {
            //System.out.println("-------------------------------------------------------------------"+principal.getName());
            // --> instructorUser2@gmai.com
            Instructor instructor = instructorService.loadInstructorByEmail(principal.getName());
            //System.out.println("-------------------------------------------------------------------"+instructor.toString());

            model.addAttribute(CURRENT_INSTRUCTOR, instructor);
        }
        Course course = courseService.loadCourseById(courseId);
        List<Instructor> instructors = instructorService.fetchInstructors();
        model.addAttribute(COURSE, course);
        model.addAttribute(LIST_INSTRUCTORS, instructors);
        return "course-views/formUpdate";
    }

    @GetMapping(value = "/formCreate")
    public String formCourses(Model model) {
        List<Instructor> instructors = instructorService.fetchInstructors();
        model.addAttribute(LIST_INSTRUCTORS, instructors);
        model.addAttribute(COURSE, new Course());
        return "course-views/formCreate";
    }

    @PostMapping(value = "/save")
    public String save(Course course) {
        courseService.createOrUpdateCourse(course);
        return "redirect:/courses/index";
    }

    @GetMapping(value = "/index/student")
    public String coursesForCurrentStudent(Model model) {
        Long studentId = 1L; // current student
        List<Course> subscribedCourses = courseService.fetchCoursesForStudent(studentId);
        List<Course> otherCourses = courseService.fetchAll().stream().filter(course -> !subscribedCourses.contains(course)).collect(Collectors.toList());
        model.addAttribute(LIST_COURSES, subscribedCourses);
        model.addAttribute(OTHER_COURSES, otherCourses);
        return "course-views/student-courses";
    }

    @GetMapping(value = "/enrollStudent")
    public String enrollCurrentStudentInCourse(Long courseId) {
        Long studentId = 1L;
        courseService.assignStudentToCourse(courseId, studentId);
        return "redirect:/courses/index/student";
    }

    @GetMapping(value = "/index/instructor")
    public String coursesForCurrentInstructor(Model model) {
        Long instructorId = 1L; // current Instructor
        Instructor instructor = instructorService.loadInstructorById(instructorId);
        model.addAttribute(LIST_COURSES, instructor.getCourses());
        return "course-views/instructor-courses";
    }
    @GetMapping(value = "/instructor")
    public String coursesByInstructorId(Model model, Long instructorId) {
        Instructor instructor = instructorService.loadInstructorById(instructorId);
        model.addAttribute(LIST_COURSES, instructor.getCourses());
        return "course-views/instructor-courses";
    }


}
