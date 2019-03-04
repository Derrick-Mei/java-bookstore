package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.repository.Bookrepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Api(value = "some value by DKM", description = "Books Controller by DKM")
@RestController
@RequestMapping(path = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class Bookcontroller
{
    @Autowired
    Bookrepository bookrepos;

    @GetMapping("")
    public List<Book> findAllBooks()
    {
        return bookrepos.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> findBookById(@PathVariable long id)
    {
        return bookrepos.findById(id);
    }

}
