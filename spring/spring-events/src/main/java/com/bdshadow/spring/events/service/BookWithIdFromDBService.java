package com.bdshadow.spring.events.service;

import com.bdshadow.spring.events.entity.Book;
import com.bdshadow.spring.events.entity.BookWithIdFromDB;
import com.bdshadow.spring.events.repo.BookRepository;
import com.bdshadow.spring.events.repo.BookWithIdFromDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class BookWithIdFromDBService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BookWithIdFromDBRepository bookRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public BookWithIdFromDB tryBookWithIdFromDB() {
        BookWithIdFromDB book = new BookWithIdFromDB();
        book.setName("New book");

        // try to publish before save to db
        applicationEventPublisher.publishEvent(book);

        BookWithIdFromDB savedBook = bookRepository.save(book);

        // both book and savedBook are fine here
        System.out.println("New book + " + book);
        System.out.println("Saved book + " + book);


        return savedBook;
    }
}
