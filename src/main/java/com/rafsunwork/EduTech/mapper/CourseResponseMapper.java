package com.rafsunwork.EduTech.mapper;

import com.rafsunwork.EduTech.dto.BookRequestDTO;
import com.rafsunwork.EduTech.dto.CourseResponseDTO;
import com.rafsunwork.EduTech.model.Courses;
import com.rafsunwork.EduTech.model.Instructors;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CourseResponseMapper {
    public CourseResponseDTO toDto(Courses courses){
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setTitle(courses.getTitle());
        courseResponseDTO.setDescription(courses.getDescription());
        courseResponseDTO.setThumbnail(courses.getThumbnail());
        courseResponseDTO.setPrice(courses.getPrice());
        courseResponseDTO.setHours(courses.getHours());
        courseResponseDTO.setReferenceBook(courses.getReferenceBook().stream().map(books -> new BookRequestDTO(books.getTitle())).collect(Collectors.toList()));
        courseResponseDTO.setInstructorsList(courses.getInstructorList());
        return courseResponseDTO;
    }
}
