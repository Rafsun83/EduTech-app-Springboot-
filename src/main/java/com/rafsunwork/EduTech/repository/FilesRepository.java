package com.rafsunwork.EduTech.repository;

import com.rafsunwork.EduTech.model.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files, Long> {
    //here write custom query if needed
}
