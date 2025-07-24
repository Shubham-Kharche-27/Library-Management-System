package com.shubham.Library.Management.System.Dto;

import java.time.LocalDate;
import java.util.List;

public class AuthorDto {
    private long authorId;
    private String authorName;
    private String authorBiography;
    private LocalDate authorDob;

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
}
