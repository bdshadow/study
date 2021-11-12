package com.bdshadow.spring.events.service;

import com.bdshadow.spring.events.entity.Book;
import com.bdshadow.spring.events.entity.BookWithIdFromDB;
import com.bdshadow.spring.events.repo.BookRepository;
import com.bdshadow.spring.events.repo.BookWithIdFromDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class BookWithIdFromDBListeners {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BookWithIdFromDBRepository bookRepository;

    @Transactional
    @EventListener
    public void standardEventListener(BookWithIdFromDB book) {
        System.out.println("standardEventListener(id-from-db) received " + book);

        // won't be saved to DB here without next "save" call, but changes the value of the book
        // from where event was published
        book.setName("Event book");

        // try to use/print the id of the surrogate ID when book is not yet flushed to db
        // will print null - meaning hibernate doesn't guess to try to fetch it
        System.out.println(book.getId());
        //bookRepository.save(book);
    }

    // without Propagation.REQUIRES_NEW changes are not committed (even with "save" call)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void transactionalEventListener(BookWithIdFromDB book) {
        System.out.println("transactionalEventListener(id-from-db) received " + book);

        book.setName("Transactional event book");

        // without "save" here, update query is not issued at all by Hibernate,
        // even with @Transactional(propagation = Propagation.REQUIRES_NEW)
        bookRepository.save(book);
    }
}
