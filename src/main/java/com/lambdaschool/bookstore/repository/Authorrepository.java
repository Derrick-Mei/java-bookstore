package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Authorrepository extends JpaRepository<Author, Long>
{
}
