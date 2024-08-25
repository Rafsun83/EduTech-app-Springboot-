package com.rafsunwork.EduTech.services;

import com.rafsunwork.EduTech.model.Instructors;
import com.rafsunwork.EduTech.repository.InstructorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServices {

    @Autowired
    private InstructorsRepository instructorsRepository;

    public List<Instructors> getAllInstructor(){
        return instructorsRepository.findAll();
    }

    public Instructors createInstructor(Instructors instructors){
       return instructorsRepository.save(instructors);
    }
}
