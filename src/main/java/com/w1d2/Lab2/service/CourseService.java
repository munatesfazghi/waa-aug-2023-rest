package com.w1d2.Lab2.service;

import com.w1d2.Lab2.dto.CourseDto;
import com.w1d2.Lab2.model.Course;

import java.util.List;

public interface CourseService {
    void save(CourseDto courseDto);
    List<CourseDto> getAll();

    CourseDto getOne(int id);

    void update(int id, CourseDto courseDto);

    void delete(int id);
}
