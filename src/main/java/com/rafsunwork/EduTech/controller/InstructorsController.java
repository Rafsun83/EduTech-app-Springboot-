package com.rafsunwork.EduTech.controller;

import com.rafsunwork.EduTech.model.Instructors;
import com.rafsunwork.EduTech.response.ApiResponse;
import com.rafsunwork.EduTech.services.InstructorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/core/instructors")
public class InstructorsController {

    @Autowired
    private InstructorServices instructorServices;

    @GetMapping
    public ResponseEntity<List<Instructors>> getAllInstructor(){
       List< Instructors> instructors = instructorServices.getAllInstructor();

       return ResponseEntity.ok().body(instructors);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructors>> createInstructor(@RequestBody Instructors instructors){
          Instructors instructor = instructorServices.createInstructor(instructors);

        ApiResponse<Instructors> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), instructor, "Instructor created successfully");

        return ResponseEntity.ok().body(apiResponse);
    }
}
