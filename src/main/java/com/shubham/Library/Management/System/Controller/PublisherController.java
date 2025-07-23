package com.shubham.Library.Management.System.Controller;

import com.shubham.Library.Management.System.Dto.PublisherDto;
import com.shubham.Library.Management.System.Service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/get")
    public ResponseEntity<Page<PublisherDto>> getAllPublishers(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "publisherId") String sortBy
    ) {
        return new ResponseEntity<>(publisherService.getAllPublisherData(pageNum - 1, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping("/get/byId/{publisherId}")
    public ResponseEntity<PublisherDto> getPublisherById(@PathVariable long publisherId) {
        return new ResponseEntity<>(publisherService.getPublisherById(publisherId), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<PublisherDto> createPublisher(@RequestBody PublisherDto publisherDto) {
        return new ResponseEntity<>(publisherService.createPublisher(publisherDto), HttpStatus.CREATED);
    }

    @PutMapping("/put/{publisherId}")
    public ResponseEntity<String> updatePublisher(@PathVariable long publisherId, @RequestBody PublisherDto publisherDto) {
        return new ResponseEntity<>(publisherService.updatePublisher(publisherId, publisherDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{publisherId}")
    public ResponseEntity<String> deletePublisher(@PathVariable long publisherId) {
        return new ResponseEntity<>(publisherService.deletePublisher(publisherId), HttpStatus.NO_CONTENT);
    }
}
