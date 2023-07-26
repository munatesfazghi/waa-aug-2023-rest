package com.w1d2.Lab2.controller;

import com.w1d2.Lab2.dto.CourseDto;
import com.w1d2.Lab2.dto.StudentDto;
import com.w1d2.Lab2.impl.StudentServicefImpl;
import com.w1d2.Lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {
    private final StudentServicefImpl studentService;


    @PostMapping
    public void save(@RequestBody StudentDto studentDto){
        studentService.save(studentDto);
    }

    @GetMapping
    public List<StudentDto> getAll(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public StudentDto getOne(@PathVariable int id){
        return studentService.getStudent(id);
    }
    @GetMapping("/major")
    public List<StudentDto> getByMajor(@RequestParam String major){
        return studentService.getStudentByMajor(major);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody StudentDto studentDto, @PathVariable int id){
        studentService.update(studentDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.deleteStudent(id);
    }
    @GetMapping("/course/{studentId}")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int studentId){
        return studentService.getCoursesByStudentId(studentId);
    }





}
