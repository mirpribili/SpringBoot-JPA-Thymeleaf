package com.javacorner.admin.service.impl;

import com.javacorner.admin.dao.CourseDao;
import com.javacorner.admin.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class CourseServiceImplTest {

    @Mock
    private CourseDao courseDao;
    @InjectMocks
    private CourseServiceImpl courseService;

    @Test
    void testLoadCourseById() {
        Course course = new Course();
        course.setCourseId(1L);

        when(courseDao.findById(any())).thenReturn(Optional.of(course));
        Course actualCourse = courseService.loadCourseById(1L);
        assertEquals(course, actualCourse);

        // So to get a hundred percent coverage, we should perform a test of all possibilities for method in hand.
        // Test the condition when no course with the given id was found.

    }
    @Test
    void testExceptionForNotFoundCourseById(){
        assertThrows(EntityNotFoundException.class, ()->courseService.loadCourseById(20L));
    }
    @Test
    void loadCourseById() {
    }

    @Test
    void createCourse() {
    }

    @Test
    void createOrUpdateCourse() {
    }

    @Test
    void findCoursesByCourseName() {
    }

    @Test
    void assignStudentToCourse() {
    }

    @Test
    void fetchAll() {
    }

    @Test
    void fetchCoursesForStudent() {
    }

    @Test
    void removeCourse() {
    }
}