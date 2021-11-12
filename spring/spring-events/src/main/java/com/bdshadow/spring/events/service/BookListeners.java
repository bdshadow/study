package com.bdshadow.spring.events.service;

import com.bdshadow.spring.events.entity.Book;
import com.bdshadow.spring.events.repo.BookRepository;
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
public class BookListeners {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @EventListener
    public void standardEventListener(Book book) {
        System.out.println("standardEventListener received " + book);

        book.setName("Event book"); // won't be applied
    }

    // without Propagation.REQUIRES_NEW changes are not committed (even with "save" call)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void transactionalEventListener(Book book) {
        System.out.println("transactionalEventListener received " + book);

        book.setName("Transactional event book");

        // without "save" here, update query is not issued at all by Hibernate,
        // even with @Transactional(propagation = Propagation.REQUIRES_NEW)
        bookRepository.save(book);
    }
}
