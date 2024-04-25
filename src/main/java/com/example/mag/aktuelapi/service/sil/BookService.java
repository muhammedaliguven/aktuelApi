package com.example.mag.aktuelapi.service.sil;

import com.example.mag.aktuelapi.model.sil.Book;
import com.example.mag.aktuelapi.repository.sil.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public String create(String name) {
        Book book=new Book();
        book.setName(name);
        bookRepository.save(book);
        return "Basarılı";
    }
}
