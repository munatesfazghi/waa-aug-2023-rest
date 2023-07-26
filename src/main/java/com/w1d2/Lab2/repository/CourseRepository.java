package com.w1d2.Lab2.repository;

import com.w1d2.Lab2.dto.CourseDto;
import com.w1d2.Lab2.model.Course;
import com.w1d2.Lab2.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CourseRepository {
    List<Course> courseList = new ArrayList<>(Arrays.asList(
            new Course(1, "Introduction to Computer Science", "CSCI101"),
            new Course(2, "Calculus I", "MATH101"),
            new Course(3, "History of Art", "ART101")
    ));

    public void save(Course course){
        courseList.add(course);
    }

    public List<Course> getAll() {
        return courseList;
    }

    public Course findOne(int id) {
        return  courseList.stream().filter(course -> course.getId() == id).findFirst().get();
    }

    public void update(Course course, int id) {
        //courseList.removeIf(course1 -> course1.getId() == id);
        delete(id);
        System.out.println("courselist " + courseList);
        courseList.add(course);
    }


    public void delete(int id) {
        courseList.removeIf(course -> course.getId() == id);
    }
}
