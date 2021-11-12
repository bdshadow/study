package com.bdshadow.spring.events.service;

import com.bdshadow.spring.events.entity.Book;
import com.bdshadow.spring.events.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class BookService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public Book saveAndUpdateBook2Times() {
        Book book = new Book(1, "Clever book");
        Book savedBook = bookRepository.save(book);

        System.out.println(savedBook);

        savedBook.setName("Very clever book");
        Book updatedBook = bookRepository.save(savedBook);

        System.out.println(updatedBook);

        // entityManager.flush(); uncomment to see how it changes the order of output

        // can be both updatedBook and savedBook here
        savedBook.setName("Not clever book");
        Book updatedBook2 = bookRepository.save(savedBook);

        System.out.println("Before publishing event: " + updatedBook2);
        applicationEventPublisher.publishEvent(updatedBook2);
        System.out.println("After publishing event: " + updatedBook2);

        return updatedBook2;
    }
}
