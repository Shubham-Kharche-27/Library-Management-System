package com.shubham.Library.Management.System.Service;

import com.shubham.Library.Management.System.Dto.PublisherDto;
import com.shubham.Library.Management.System.Entity.Publisher;
import com.shubham.Library.Management.System.Exception.PublisherNotFoundException;
import com.shubham.Library.Management.System.Repository.PublisherRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepo publisherRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PublisherDto> getAllPublisherData(int pageNum, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        Page<Publisher> publisherPage = publisherRepo.findAll(pageable);
        return publisherPage.map(Publisher -> modelMapper.map(Publisher, PublisherDto.class));
    }

    public PublisherDto getPublisherById(long publisherId) {
        Publisher publisher = publisherRepo.findById(publisherId)
                .orElseThrow(() -> new PublisherNotFoundException("Publisher does not exist!"));
        return modelMapper.map(publisher, PublisherDto.class);
    }

    public PublisherDto createPublisher(PublisherDto publisherDto) {
        Publisher publisher = modelMapper.map(publisherDto, Publisher.class);
        return modelMapper.map(publisherRepo.save(publisher), PublisherDto.class);
    }

    public String updatePublisher(long publisherId, PublisherDto publisherDto) {
        Publisher publisher = publisherRepo.findById(publisherId)
                .orElseThrow(() -> new PublisherNotFoundException("Publisher does not exist!"));
        if (publisherDto.getPublisherName() != null) {
            publisher.setPublisherName(publisherDto.getPublisherName());
        }
        if (publisherDto.getPublisherAddress() != null) {
            publisher.setPublisherAddress(publisherDto.getPublisherAddress());
        }
        if (publisherDto.getPublisherContactNum() != 0) {
            publisher.setPublisherContactNum(publisherDto.getPublisherContactNum());
        }
        publisherRepo.save(publisher);
        return "Publisher updated successfully!";
    }

    public String deletePublisher(long publisherId) {
        Publisher publisher = publisherRepo.findById(publisherId)
                .orElseThrow(() -> new PublisherNotFoundException("publisher does not exist!"));
        publisherRepo.deleteById(publisherId);
        return "Publisher deleted successfully!";
    }
}
