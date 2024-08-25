package com.rafsunwork.EduTech.repository;

import com.rafsunwork.EduTech.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
    //write here if needed any custom query ;
}
