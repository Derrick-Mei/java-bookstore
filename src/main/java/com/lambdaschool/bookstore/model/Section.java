package com.lambdaschool.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "section")
public class Section
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sectionid;

    private String name;

    //OneToMany to books
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "section")  //should we have cascade? or just detach? basically should column in book be nullable
    @JsonIgnoreProperties("sections")
    private Set<Book> books;

    public Section()
    {
    }

    public long getSectionid()
    {
        return sectionid;
    }

    public void setSectionid(long sectionid)
    {
        this.sectionid = sectionid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<Book> getBooks()
    {
        return books;
    }

    public void setBooks(Set<Book> books)
    {
        this.books = books;
    }
}
