package com.w1d2.Lab2.controller;

import com.w1d2.Lab2.dto.CourseDto;
import com.w1d2.Lab2.impl.CourseServiceImpl;
import com.w1d2.Lab2.model.Course;
import com.w1d2.Lab2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@CrossOrigin
public class CourseController {
    private final CourseServiceImpl courseService;

    @PostMapping
    public void save(@RequestBody CourseDto courseDto){
        courseService.save(courseDto);
    }
    @GetMapping
    public List<CourseDto> getAll(){
        return courseService.getAll();
    }
    @GetMapping("/{id}")
    public CourseDto getOne(@PathVariable int id){
       return courseService.getOne(id);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody CourseDto courseDto, @PathVariable int id){
        courseService.update(id, courseDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }
}
