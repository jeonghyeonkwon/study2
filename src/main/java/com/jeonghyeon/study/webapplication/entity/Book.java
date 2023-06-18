package com.jeonghyeon.study.webapplication.entity;


import javax.persistence.*;

@Entity
@Table(name="T_BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;

    private Long bookPrice;

    private String ownerUser;

    protected Book(){}

    public Book(String bookName, Long bookPrice, String ownerUser) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.ownerUser = ownerUser;
    }

    public Long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public Long getBookPrice() {
        return bookPrice;
    }

    public String getOwnerUser() {
        return ownerUser;
    }
}
