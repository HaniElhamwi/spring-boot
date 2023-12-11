package com.hibernatespringboot.learnhibernateandjpa.course.CourseSpringDataJpaRepository;

import com.hibernatespringboot.learnhibernateandjpa.course.courseClass.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long> {
}
