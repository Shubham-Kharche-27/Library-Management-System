package com.shubham.Library.Management.System.Dto;


import java.util.List;

public class PublisherDto {
    private long publisherId;
    private String publisherName;
    private String publisherAddress;
    private long publisherContactNum;

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

    public long getPublisherContactNum() {
        return publisherContactNum;
    }

    public void setPublisherContactNum(long publisherContactNum) {
        this.publisherContactNum = publisherContactNum;
    }
}
