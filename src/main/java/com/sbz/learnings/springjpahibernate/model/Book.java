package com.sbz.learnings.springjpahibernate.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String authorName;
    private String bookName;
    private Date publishedDate;

    public Book() {
    }

    public Book(Long id, String authorName, String bookName, Date publishedDate) {
        this.id = id;
        this.authorName = authorName;
        this.bookName = bookName;
        this.publishedDate = publishedDate;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getAuthor() {
        return authorName;
    }

    public void setAuthor(String authorId) {
        this.authorName = authorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
