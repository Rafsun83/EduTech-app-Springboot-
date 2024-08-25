package com.rafsunwork.EduTech;

import com.rafsunwork.EduTech.repository.BooksRepository;
import com.rafsunwork.EduTech.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EduTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduTechApplication.class, args);
	}

	@Autowired
	private CoursesRepository coursesRepository;
	private BooksRepository booksRepository;

}
