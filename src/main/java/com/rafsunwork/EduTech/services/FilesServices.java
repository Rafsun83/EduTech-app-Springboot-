package com.rafsunwork.EduTech.services;

import com.rafsunwork.EduTech.model.Files;
import com.rafsunwork.EduTech.repository.FilesRepository;
import com.rafsunwork.EduTech.utils.FilesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FilesServices {


    @Autowired
    private FilesRepository filesRepository;

    public Files uploadFiles(MultipartFile file) throws IOException {

        return filesRepository.save(Files.builder().name(file.getOriginalFilename()).type(file.getContentType()).fileData(FilesUtils.compressFiles(file.getBytes())).build());
//        return "file Uploaded successfully"+ file.getOriginalFilename();

    }

}
