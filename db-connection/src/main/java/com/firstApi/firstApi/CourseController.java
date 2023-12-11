package com.firstApi.firstApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CourseController {


    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(String name) {
        return List.of(
            new Course(1L, "Spring Boot", "Miguel"),
            new Course(2L, "React", "Miguel")
        );
    }
}
