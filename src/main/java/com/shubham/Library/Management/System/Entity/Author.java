package com.shubham.Library.Management.System.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorId;
    private String authorName;
    private String authorBiography;
    private LocalDate authorDob;

    @OneToMany(mappedBy = "author", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Book> books;

    public Author(long authorId, String authorName, String authorBiography, LocalDate authorDob, List<Book> books) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorBiography = authorBiography;
        this.authorDob = authorDob;
        this.books = books;
    }

    public Author() {
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorBiography() {
        return authorBiography;
    }

    public void setAuthorBiography(String authorBiography) {
        this.authorBiography = authorBiography;
    }

    public LocalDate getAuthorDob() {
        return authorDob;
    }

    public void setAuthorDob(LocalDate authorDob) {
        this.authorDob = authorDob;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
