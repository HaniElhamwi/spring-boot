package com.hibernatespringboot.learnhibernateandjpa.course.jdbc;

import com.hibernatespringboot.learnhibernateandjpa.course.courseClass.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
   private JdbcTemplate springJdbcTemplate;
   private  static String INSERT_QUERY =
           """
          insert into course (id,name,author)
          values(?,? ,?)
           """;

   public void inset(Course course){
       springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
   }

   public  void delete(long id){
       springJdbcTemplate.update("delete from course where id=?",id);
   }
}
