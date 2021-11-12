package com.bdshadow.spring.events.repo;

import com.bdshadow.spring.events.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
