package com.w1d2.Lab2.service;

import com.w1d2.Lab2.dto.CourseDto;
import com.w1d2.Lab2.dto.StudentDto;

import java.util.List;

public interface StudentService {
    void save(StudentDto studentDto);
    void update(StudentDto studentDto, int id);
    void deleteStudent(int id);
    StudentDto getStudent(int id);
    List<StudentDto> getAllStudents();
    List<StudentDto> getStudentByMajor(String major);

    List<CourseDto> getCoursesByStudentId(int studentId);
}
