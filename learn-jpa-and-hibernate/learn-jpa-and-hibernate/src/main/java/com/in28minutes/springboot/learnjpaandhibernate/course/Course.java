package com.in28minutes.springboot.learnjpaandhibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Course {
    @Id
    private long id;
    private String name;
    private String author;
}
