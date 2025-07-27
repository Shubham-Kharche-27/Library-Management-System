package com.shubham.Library.Management.System.Dto;


import java.util.ArrayList;
import java.util.List;

public class PublisherDto {
    private long publisherId;
    private String publisherName;
    private String publisherAddress;
    private String publisherContactNum;
    List<BookDto> bookList = new ArrayList<>();

    public List<BookDto> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookDto> bookList) {
        this.bookList = bookList;
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
}
