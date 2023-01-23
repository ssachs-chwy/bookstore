package com.chewy.bookstore.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    private long id;
    private String title;
    private long authorId;
    private String publisher;
    private int yearPublished;
    private int price;
    private boolean isFeatured;
    private int coverPrettiness;

    public Book() {}

    public Book(long id, String title, long authorId, String publisher, int yearPublished, int price, boolean isFeatured, int coverPrettiness) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.price = price;
        this.isFeatured = isFeatured;
        this.coverPrettiness = coverPrettiness;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "authorId", nullable = false)
    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    @Column(name = "publisher", nullable = false)
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Column(name = "yearPublished", nullable = false)
    public int yearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "isFeatured", nullable = false)
    public boolean getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    @Column(name = "coverPrettiness", nullable = false)
    public int getCoverPrettiness() {
        return coverPrettiness;
    }

    public void setCoverPrettiness(int coverPrettiness) {
        this.coverPrettiness = coverPrettiness;
    }
}