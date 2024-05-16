package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class Jpa{
    @PersistenceContext
    private EntityManager entityManager;
    public void insert(Course course)
    {
         entityManager.merge(course);
         return;
    }
    public Course findById(long id)
    {
        return entityManager.find(Course.class,id);
    }
    public void delete(long id)
    {
        Course course=entityManager.find(Course.class,id);
        entityManager.remove(course);
        return;
    }
}
