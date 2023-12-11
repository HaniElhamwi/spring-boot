package com.hibernatespringboot.learnhibernateandjpa.course;
import com.hibernatespringboot.learnhibernateandjpa.course.CourseSpringDataJpaRepository.CourseSpringDataJpaRepository;
import com.hibernatespringboot.learnhibernateandjpa.course.Jpa.CourseJpaRepository;
import com.hibernatespringboot.learnhibernateandjpa.course.courseClass.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CoueseCommandLineRunnder implements CommandLineRunner {
//    @Autowired
//    private CourseJpaRepository courseJpaRepository;

    @Autowired
    CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(10001,"Spring Boot JPA","Ranga"));
        repository.save(new Course(10002,"AWS LEARNING JPA","Ranga 2"));
        repository.deleteById(10001l);

        System.out.println(repository.findAll());
    }
}
