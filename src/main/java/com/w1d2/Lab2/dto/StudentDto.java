package com.w1d2.Lab2.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    List<CourseDto> coursesTakenDtos;


}
