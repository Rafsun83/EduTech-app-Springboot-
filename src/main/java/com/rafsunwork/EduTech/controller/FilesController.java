package com.rafsunwork.EduTech.controller;

import com.rafsunwork.EduTech.model.Files;
import com.rafsunwork.EduTech.response.ApiResponse;
import com.rafsunwork.EduTech.services.FilesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/core/file")
public class FilesController {

    @Autowired
    private FilesServices filesServices;

    @PostMapping
    public ResponseEntity<ApiResponse<Files>> uploadFiles(@RequestParam("image") MultipartFile file) throws IOException {

        try {
            Files files = filesServices.uploadFiles(file);
            ApiResponse<Files> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), files, "File Uploaded Successfully");
            return ResponseEntity.ok().body(apiResponse);

        } catch (MaxUploadSizeExceededException e){
            ApiResponse<Files> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), null, "File size exceeds the maximum upload limit!");
            return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body(apiResponse);
        } catch (Exception e) {
            ApiResponse<Files> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), null, "File size exceeds the maximum upload limit!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }


    }
}
