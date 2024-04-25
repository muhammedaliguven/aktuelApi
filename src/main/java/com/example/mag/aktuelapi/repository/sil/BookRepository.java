package com.example.mag.aktuelapi.repository.sil;

import com.example.mag.aktuelapi.model.sil.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

}

