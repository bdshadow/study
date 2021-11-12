package com.bdshadow.spring.events.repo;

import com.bdshadow.spring.events.entity.BookWithIdFromDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookWithIdFromDBRepository extends JpaRepository<BookWithIdFromDB, Integer> {
}
