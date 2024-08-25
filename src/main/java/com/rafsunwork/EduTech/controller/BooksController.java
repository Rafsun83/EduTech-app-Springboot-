package com.rafsunwork.EduTech.controller;

import com.rafsunwork.EduTech.model.Books;
import com.rafsunwork.EduTech.response.ApiResponse;
import com.rafsunwork.EduTech.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/core/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<ApiResponse<Books>> createBooks(@RequestBody Books books){

        Books book = bookService.createBook(books);

        HttpHeaders headerResponse = new HttpHeaders();
        headerResponse.set("response-message", "Books created successfully");
        ApiResponse<Books> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), book, "Book created successfully");

        return ResponseEntity.ok().headers(headerResponse).body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<List<Books>> getAllBooks(){
        List<Books> books = bookService.getAllBooks();
         return ResponseEntity.ok().body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Books>> getBookById(@PathVariable Long id){
        Books books = bookService.getBookById(id);

        if(books == null){
            ApiResponse<Books> apiResponse = new ApiResponse<>(HttpStatus.NOT_FOUND.value(), null, "Book is not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }

        ApiResponse<Books> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), books, "Single Books retrieved successfully");
        return ResponseEntity.ok().body(apiResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Books>> updateBook(@PathVariable Long id, @RequestBody Books books){
        Books updateBook = bookService.updateBook(id, books);

        ApiResponse<Books> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), updateBook, "Book updated successfully");
        return ResponseEntity.ok().body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        ApiResponse<?> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", "Book deleted successfully");
        return ResponseEntity.ok().body(apiResponse);
    }
}
