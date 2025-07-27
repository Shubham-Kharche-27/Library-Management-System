package com.shubham.Library.Management.System.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long publisherId;
    private String publisherName;
    private String publisherAddress;
    private String publisherContactNum;

    @OneToMany(mappedBy = "publisher", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Book> books;

    public Publisher(long publisherId, String publisherName, String publisherAddress, String publisherContactNum, List<Book> books) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        this.publisherAddress = publisherAddress;
        this.publisherContactNum = publisherContactNum;
        this.books = books;
    }

    public Publisher() {
    }

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public String getPublisherContactNum() {
        return publisherContactNum;
    }

    public void setPublisherContactNum(String publisherContactNum) {
        this.publisherContactNum = publisherContactNum;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
