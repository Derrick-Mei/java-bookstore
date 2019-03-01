package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.Section;
import com.lambdaschool.bookstore.repository.Sectionrepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "some value... by DKM", description = "Section Controller by DKM")
@RestController
@RequestMapping(path = "/sections", produces = MediaType.APPLICATION_JSON_VALUE)
public class Sectioncontroller
{
    @Autowired
    Sectionrepository sectionrepos;

    @GetMapping("")
    public List<Section> getAllSections()
    {
        return sectionrepos.findAll();
    }
}
