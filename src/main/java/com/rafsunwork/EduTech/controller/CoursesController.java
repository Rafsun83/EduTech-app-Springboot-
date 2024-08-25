package com.rafsunwork.EduTech.controller;

import com.rafsunwork.EduTech.dto.CourseResponseDTO;
import com.rafsunwork.EduTech.mapper.CourseResponseMapper;
import com.rafsunwork.EduTech.model.Courses;
import com.rafsunwork.EduTech.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rafsunwork.EduTech.services.CourseServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/core/courses")
public class CoursesController {

    @Autowired
    private CourseServices courseServices;

    @Autowired
    private  CourseResponseMapper courseResponseMapper;

    @PostMapping
    public ResponseEntity<ApiResponse<Courses>> createCourse(@RequestBody Courses courses){
        Courses courses1 = courseServices.createCourse(courses);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("response-message", "Course created successfully");
        ApiResponse<Courses> dataResponse = new ApiResponse<>(HttpStatus.OK.value(), courses1, "Course created successfully");

        return ResponseEntity.ok().headers(responseHeaders).body(dataResponse);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseResponseDTO>>> getAllCourse(){
        List<CourseResponseDTO> course = courseServices.getAllCourse().stream().map(courseResponseMapper::toDto).collect(Collectors.toList());
//        List<Courses> course = courseServices.getAllCourse();

        System.out.println("Course list---"+ course);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("response-message", "Data retrieved successfully");
        String message = course.isEmpty() ? "No course found" : "Courses retrieved successfully";
        ApiResponse<List<CourseResponseDTO>> dataResponse = new ApiResponse<>(HttpStatus.OK.value(),course, message);

        return ResponseEntity.ok().headers(responseHeaders).body(dataResponse);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ApiResponse<Courses>> getCourseById(@PathVariable Long id){
        Courses courses = courseServices.getCourseById(id);

        ApiResponse<Courses> dataResponse = new ApiResponse<>(HttpStatus.OK.value(),courses, "Single course retrieved successfully");
        return ResponseEntity.ok().body(dataResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Courses>> updateCourse(@PathVariable Long id, @RequestBody Courses courseDetails){
        Courses courses = courseServices.updateCourse(id, courseDetails);
        ApiResponse<Courses> dataResponse = new ApiResponse<>(HttpStatus.OK.value(), courses, "Course Updated successfully");

        return ResponseEntity.ok().body(dataResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>>deleteCourse(@PathVariable Long id){
        courseServices.deleteCourseById(id);
        ApiResponse<?> dataResponse = new ApiResponse<>(HttpStatus.OK.value(),"", "Course deleted successfully");

        return ResponseEntity.ok().body(dataResponse);
    }
}
