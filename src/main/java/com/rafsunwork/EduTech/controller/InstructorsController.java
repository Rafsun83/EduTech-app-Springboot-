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

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructors>> getInstructorById(@PathVariable Long id){
        Instructors instructor = instructorServices.getInstructorById(id);

        ApiResponse<Instructors>apiResponse = new ApiResponse<>(HttpStatus.OK.value(), instructor, "Single Course retrieve successfully");
        return ResponseEntity.ok().body(apiResponse);

    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructors>> createInstructor(@RequestBody Instructors instructors){
          Instructors instructor = instructorServices.createInstructor(instructors);

        ApiResponse<Instructors> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), instructor, "Instructor created successfully");

        return ResponseEntity.ok().body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructors>>updateInstructor(@PathVariable Long id, @RequestBody Instructors instructors){
        Instructors instructor = instructorServices.updateInstructor(id, instructors);

        ApiResponse<Instructors> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), instructor, "Updated successfully");
       return ResponseEntity.ok().body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteInstructor(@PathVariable Long id){
        instructorServices.deleteInstructor(id);

        ApiResponse<?> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", "Instructor deleted successfully");
        return ResponseEntity.ok().body(apiResponse);
    }
}
