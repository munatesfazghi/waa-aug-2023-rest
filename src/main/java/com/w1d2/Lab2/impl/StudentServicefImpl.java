package com.w1d2.Lab2.impl;

import com.w1d2.Lab2.dto.CourseDto;
import com.w1d2.Lab2.dto.StudentDto;
import com.w1d2.Lab2.model.Course;
import com.w1d2.Lab2.model.Student;
import com.w1d2.Lab2.repository.StudentRepository;
import com.w1d2.Lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServicefImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        studentRepository.save(student);


    }

    @Override
    public void update(StudentDto studentDto, int id) {
        Student student = studentRepository.getStudent(id);
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setMajor(studentDto.getMajor());
        studentRepository.updateStudent(student, id);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }

    @Override
    public StudentDto getStudent(int id) {
        Student student = studentRepository.getStudent(id);
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> studentList = studentRepository.getAll();
        System.out.println("studentlist" + studentList);
        List<StudentDto> studentDtoList = new ArrayList<>();

        studentList.forEach(student -> {
            List<Course> courseList = student.getCoursesTaken();
            List<CourseDto> courseDtos = courseList.stream().map(course -> modelMapper.map(course, CourseDto.class)).toList();

            StudentDto studentDto = modelMapper.map(student, StudentDto.class);
            studentDto.setCoursesTakenDtos(courseDtos);
            studentDtoList.add(studentDto);
        });
        return studentDtoList;
    }

    @Override
    public List<StudentDto> getStudentByMajor(String major) {
        System.out.println("calling this method");
          List<StudentDto> studentDtoList = getAllStudents();
          List<StudentDto> studentDtoListByMajor = new ArrayList<>();
        for (StudentDto studentDto : studentDtoList) {
            if(studentDto.getMajor().equals(major)){
                System.out.println("studentdto" + studentDto);
                studentDtoListByMajor.add(studentDto);
            }
        }
        return studentDtoListByMajor;
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        Student student = studentRepository.getStudent(studentId);
        List<Course> courses =  student.getCoursesTaken();
        List<CourseDto> courseDtos = new ArrayList<>();
        courses.forEach(course -> {
            CourseDto courseDto = modelMapper.map(course, CourseDto.class);
            courseDtos.add(courseDto);
        });
        return courseDtos;
    }
}
