package com.rafsunwork.EduTech.services;

import com.rafsunwork.EduTech.model.Books;
import com.rafsunwork.EduTech.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    //This is service, write here if needed any business logic

    @Autowired
    private BooksRepository booksRepository;

    public List<Books> getAllBooks(){
        return booksRepository.findAll();
    }

    public Books createBook(Books books){
     return booksRepository.save(books);
    }

    public Books getBookById(Long id){
        return booksRepository.findById(id).orElse(null);
    }

    public Books updateBook(Long id, Books booksDetails){

        Books books = booksRepository.findById(id).orElse(null);

        if(books != null){
            books.setTitle(booksDetails.getTitle());
            books.setSummary(booksDetails.getSummary());
            books.setThumbnail(booksDetails.getThumbnail());
            books.setTotal_page(booksDetails.getTotal_page());
            books.setPdf_url(booksDetails.getPdf_url());
            booksRepository.save(books);
        }
        return books;
    }

    public void deleteBook(Long id){
        booksRepository.deleteById(id);
    }
}
