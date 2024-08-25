package com.rafsunwork.EduTech.repository;

import com.rafsunwork.EduTech.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
    // I can define custom query methods here if needed
}
