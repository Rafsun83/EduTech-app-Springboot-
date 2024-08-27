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

    public Instructors getInstructorById(Long id){
        return instructorsRepository.findById(id).orElse(null);
    }

    public Instructors createInstructor(Instructors instructors){
       return instructorsRepository.save(instructors);
    }

    public Instructors updateInstructor( Long id, Instructors instructorDetails){
        Instructors instructor = instructorsRepository.findById(id).orElse(null);
        if(instructor != null){
            instructor.setName(instructorDetails.getName());
            instructor.setDegree(instructorDetails.getDegree());
            instructor.setPosition(instructorDetails.getPosition());
            instructor.setPreviousExperience(instructorDetails.getPreviousExperience());
            instructor.setEmail(instructorDetails.getEmail());
            instructor.setImg_url(instructorDetails.getImg_url());
            instructorsRepository.save(instructor);
        }
        return instructor;
    }

    public void deleteInstructor(Long id){
         instructorsRepository.deleteById(id);
    }
}
