package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.SpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class Runner implements CommandLineRunner {
    /*@Autowired
    private Jpa runner ;
    /*@Autowired
    private SpringJdbc runner;*/
    @Autowired
    private SpringDataJpaRepository runner;
    @Override
    public void run(String... args) throws Exception {
        runner.save(new Course(101,"Learn FULLSTACK Jpa","ashok"));
        runner.save(new Course(102,"Learn AWS Jpa","saikiran"));
        runner.save(new Course(103,"Learn Devops Jpa","saikumar"));
        runner.save(new Course(104,"Learn Devops Jpa","prasanna"));
        runner.deleteById(104l);
        System.out.println(runner.findById(101l));
        System.out.println(runner.findById(102l));
        System.out.println(runner.findByAuthor("ashok"));
        System.out.println(runner.findByName("Learn FULLSTACK Jpa"));
    }
}
