package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Bookrepository extends JpaRepository<Book, Long>
{
    @Query(value = "INSERT INTO wrote (bookid, authorid) VALUES (:bookid, :authorid);", nativeQuery = true)
    public void addToWrote(long bookid, long authorid);
}
