package com.rafsunwork.EduTech.repository;

import com.rafsunwork.EduTech.model.Instructors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorsRepository extends JpaRepository<Instructors, Long> {
    //here will write custom query;
}
