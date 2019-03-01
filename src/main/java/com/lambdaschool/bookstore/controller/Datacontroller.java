package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.Author;
import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.repository.Authorrepository;
import com.lambdaschool.bookstore.repository.Bookrepository;
import com.lambdaschool.bookstore.repository.Sectionrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
public class Datacontroller
{
    @Autowired
    Authorrepository authorrepos;

    @Autowired
    Bookrepository bookrepos;

    @Autowired
    Sectionrepository sectionrepos;

    @PutMapping("/books/{id}")
    public Book updateBookById(@RequestBody Book updatedBook, @PathVariable long id) throws URISyntaxException
    {
        Optional<Book> foundBook = bookrepos.findById(id);
        if (foundBook.isPresent())
        {
            if (updatedBook.getAuthors() == null) updatedBook.setAuthors(foundBook.get().getAuthors());
            if (updatedBook.getSection() == null) updatedBook.setSection(foundBook.get().getSection());
            if (updatedBook.getTitle() == null) updatedBook.setTitle(foundBook.get().getTitle());
            if (updatedBook.getIsbn() == null) updatedBook.setIsbn((foundBook.get().getIsbn()));
            if (updatedBook.getCopy() == 0) updatedBook.setCopy(foundBook.get().getCopy());
            updatedBook.setBookid(id);
            return bookrepos.save(updatedBook);
        }
        else
        {
            return null;
        }
    }

    @PostMapping("/books/author/{authorid}")
    public Optional<Author> addBookToAuthor(@RequestBody Book newBook, @PathVariable long authorid)
    {
        long bookid = newBook.getBookid();

        Optional<Book> foundBook = bookrepos.findById(bookid);
        Optional<Author> foundAuthor = authorrepos.findById(authorid);

        if (foundBook.isPresent() & foundAuthor.isPresent())
        {
            bookrepos.addToWrote(bookid, authorid);
            return authorrepos.findById(authorid);
        }
        else
        {
            return null;
        }
    }

    @PostMapping("/books/{bookid}/author/{authorid}")
    public Optional<Author> addBookToAuthorWithBothIds(@PathVariable long bookid, @PathVariable long authorid)
    {
        if (bookrepos.findById(bookid).isPresent() & authorrepos.findById(authorid).isPresent())
        {
            bookrepos.addToWrote(bookid, authorid);
            return authorrepos.findById(authorid);
        }
        else
        {
            return null;
        }

    }

    @DeleteMapping("/books/{id}")
    public Book deleteBookById(@PathVariable long id)
    {
        Optional<Book> foundBook = bookrepos.findById(id);
        if (foundBook.isPresent())
        {
            bookrepos.deleteById(id);
            return foundBook.get();
        }
        else
        {
            return null;
        }
    }

}
