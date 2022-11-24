package com.spbt.jpa.repository;

import com.spbt.jpa.domain.book.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
