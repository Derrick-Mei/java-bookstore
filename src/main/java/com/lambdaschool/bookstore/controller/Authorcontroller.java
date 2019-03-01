package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.Author;
import com.lambdaschool.bookstore.repository.Authorrepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Some value... by DKM", description = "Author Controller by DKM")
@RestController
@RequestMapping(value = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
public class Authorcontroller
{
    @Autowired
    Authorrepository authorrepos;

    @GetMapping("")
    public List<Author> findAllAuthors()
    {
        return authorrepos.findAll();
    }
}
