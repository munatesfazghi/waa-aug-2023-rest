package com.w1d2.Lab2.impl;

import com.w1d2.Lab2.dto.CourseDto;
import com.w1d2.Lab2.model.Course;
import com.w1d2.Lab2.repository.CourseRepository;
import com.w1d2.Lab2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    @Override
    public void save(CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        Course course1 = new Course();
        course1.setCourseCode(courseDto.getCourseCode());
        courseRepository.save(course);
    }

    @Override
    public List<CourseDto> getAll() {
        List<Course> courseList = courseRepository.getAll();
        List<CourseDto> courseDtoList = new ArrayList<>();
        courseList.forEach(course -> {
            CourseDto courseDto = modelMapper.map(course, CourseDto.class);
            courseDtoList.add(courseDto);
        });
        return courseDtoList;
    }

    @Override
    public CourseDto getOne(int id) {
        Course course = courseRepository.findOne(id);
        CourseDto courseDto = modelMapper.map(course, CourseDto.class);
        return courseDto;
    }

    @Override
    public void update(int id, CourseDto courseDto) {
        Course course = courseRepository.findOne(id);
        course.setId(courseDto.getId());
        course.setName(courseDto.getName());
        course.setCourseCode(courseDto.getCourseCode());
        courseRepository.update(course,id);
    }

    @Override
    public void delete(int id) {
        courseRepository.delete(id);
    }
}
