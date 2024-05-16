package com.in28minutes.springboot.learnjpaandhibernate.jdbc;
import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;
@Repository
public class SpringJdbc
{
    @Autowired
    private JdbcTemplate SpringJdbcTemplate;
    private String query =
            """              
                  insert into Course(id,name,author) values(?,?,?);            
            """;
    private String delquery =
            """           
                 delete from Course where id=? ;                  
            """;
    private String selectquery =
            """   
                     select * from Course where id=?;                     
            """;
    public void insert (Course course)
    {

        SpringJdbcTemplate.update (query, course.getId (), course.getName (),course.getAuthor());
    }
    public void delete (long id)
    {
        SpringJdbcTemplate.update (delquery, id);
    }
public Course findById (long id)
{

    //Result -> Bean By RowMapper
    return SpringJdbcTemplate.queryForObject(selectquery, new BeanPropertyRowMapper<>(Course.class),id);

}
}
