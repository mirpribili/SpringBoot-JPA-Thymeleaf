package com.javacorner.admin.dao;

import com.javacorner.admin.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseDao extends JpaRepository<Course, Long> {
    List<Course> findCoursesByCourseNameContains(String keyword); // create with ultimate ver hints

    @Query(value =
            "select * from courses as c where c.course_id (select e.course_id from enrolled_in as e where e.student_id=:studentId)",
            nativeQuery = true)
    List<Course> getCoursesByStudentId(@Param("studentId") Long studentId);
}