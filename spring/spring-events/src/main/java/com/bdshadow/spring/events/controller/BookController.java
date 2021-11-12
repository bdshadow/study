package com.bdshadow.spring.events.controller;

import com.bdshadow.spring.events.entity.Book;
import com.bdshadow.spring.events.entity.BookWithIdFromDB;
import com.bdshadow.spring.events.service.BookService;
import com.bdshadow.spring.events.service.BookWithIdFromDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookWithIdFromDBService bookWithIdFromDBService;

    @GetMapping("book")
    public String triggerBook() {
        Book imagineThatItsDto = bookService.saveAndUpdateBook2Times();
        return imagineThatItsDto.toString();
    }

    @GetMapping("bookDB")
    public String triggerBookWithIDFromDB() {
        BookWithIdFromDB imagineThatItsDto = bookWithIdFromDBService.tryBookWithIdFromDB();
        return imagineThatItsDto.toString();
    }
}
