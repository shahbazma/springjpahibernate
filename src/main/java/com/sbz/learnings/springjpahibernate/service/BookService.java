package com.sbz.learnings.springjpahibernate.service;

import com.sbz.learnings.springjpahibernate.AuthorRepository;
import com.sbz.learnings.springjpahibernate.BookRepository;
import com.sbz.learnings.springjpahibernate.exception.NoBookFoundException;
import com.sbz.learnings.springjpahibernate.model.Author;
import com.sbz.learnings.springjpahibernate.model.Book;
import com.sbz.learnings.springjpahibernate.model.BookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String saveBook(Book book) {
        Long id = bookRepository.save(book).getId();
        Long authorId = saveAuthor(book);
        return id.toString() + authorId.toString();
    }

    private Long saveAuthor(Book book) {
        Author author = new Author();
        author.setAuthorName(book.getAuthor());
        throw new NoBookFoundException("");
//        return authorRepository.save(author).getAuthorId();
    }

    public BookList getAllBooks() {
        List<Book> all = bookRepository.getAllBooks();
        return new BookList(all);
    }

    public List<Book> findBookByAuthor(String author) {
        List<Book> byAuthor = bookRepository.findByAuthorName(author);
        System.out.println(byAuthor);
        if (byAuthor.isEmpty()) {
            throw new NoBookFoundException("No book available!!");
        }
        return byAuthor;
    }

}
