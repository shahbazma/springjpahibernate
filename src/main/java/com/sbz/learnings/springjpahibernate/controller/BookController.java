package com.sbz.learnings.springjpahibernate.controller;

import com.sbz.learnings.springjpahibernate.model.Book;
import com.sbz.learnings.springjpahibernate.model.BookList;
import com.sbz.learnings.springjpahibernate.model.Employee;
import com.sbz.learnings.springjpahibernate.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController("/")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private RestTemplate myRestTemplate;

    @PostMapping("myJpaApp/saveBook")
    public String saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping(value = "myJpaApp/getAllBook", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public BookList getAllBook() {
        return bookService.getAllBooks();
    }

    @GetMapping("myJpaApp/findBookByAuthor/{author}")
    public List<Book> bookByAuthor(@PathVariable String author) {
        return bookService.findBookByAuthor(author);
    }

    @GetMapping("myJpaApp/getAllEmployees")
    public Employee getAllEmployess() {
        return myRestTemplate.getForObject(
                "http://dummy.restapiexample.com/api/v1/employees", Employee.class);
    }


}
