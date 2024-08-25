package com.rafsunwork.EduTech.services;

import com.rafsunwork.EduTech.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.rafsunwork.EduTech.repository.CoursesRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CourseServices {
    @Autowired
    private CoursesRepository coursesRepository;
    //Service is created for write business logic if needed

    public Courses createCourse(Courses courses){
        return coursesRepository.save(courses);
    }

    public List<Courses> getAllCourse(){
        return coursesRepository.findAll();
    }

    public Courses getCourseById(Long id){
        return coursesRepository.findById(id).orElse(null);
    }

    public Courses updateCourse(Long id, Courses courseDetails){
        Courses courses = coursesRepository.findById(id).orElse(null);
        if (courses != null){
            courses.setTitle(courseDetails.getTitle());
            courses.setDescription(courseDetails.getDescription());
            courses.setThumbnail(courseDetails.getThumbnail());
            courses.setPrice(courseDetails.getPrice());
            courses.setHours(courseDetails.getHours());
            coursesRepository.save(courses);
        }
        return courses;
    }

    public void deleteCourseById(Long id){
         coursesRepository.deleteById(id);
    }
}
