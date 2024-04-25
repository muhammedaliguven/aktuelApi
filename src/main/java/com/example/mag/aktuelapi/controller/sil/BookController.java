package com.example.mag.aktuelapi.controller.sil;

import com.example.mag.aktuelapi.model.sil.Book;
import com.example.mag.aktuelapi.service.sil.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<String> createBook(@RequestBody String name ) {
        String response= bookService.create(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
