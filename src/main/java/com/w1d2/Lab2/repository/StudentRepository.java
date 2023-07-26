package com.w1d2.Lab2.repository;

import com.w1d2.Lab2.model.Course;
import com.w1d2.Lab2.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository

public class StudentRepository {

//    List<Student> studentList = new ArrayList<>(Arrays.asList(
//            new Student(1, "John", "Doe", "john.doe@example.com", "Computer Science"),
//            new Student(2, "Jane", "Smith", "jane.smith@example.com", "Biology"),
//            new Student(3, "Michael", "Johnson", "michael.johnson@example.com", "Engineering")
//    ));
List<Student> studentList = Arrays.asList(
        new Student(1, "John", "Doe", "john.doe@example.com", "Computer Science",
                Arrays.asList(
                        new Course(1, "Introduction to Computer Science", "CSCI101"),
                        new Course(2, "Calculus I", "MATH101")
                )),
        new Student(2, "Jane", "Smith", "jane.smith@example.com", "Biology",
                Arrays.asList(
                        new Course(3, "Biology Basics", "BIO101"),
                        new Course(4, "Chemistry Fundamentals", "CHEM101")
                ))
);


    public void save(Student student){
       studentList.add(student);
    }

    public List<Student> getAll(){
      //  System.out.println(studentMap);
        return studentList;
    }
    public Student getStudent(int id){
       return studentList.stream().filter(student -> student.getId()==id).findFirst().get();
    }
    public void updateStudent(Student student, int id){
        deleteStudent(id);
        studentList.add(student);
    }
    public void deleteStudent(int id){
        studentList.removeIf(s -> s.getId() == id);
    }


}
