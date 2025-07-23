package com.shubham.Library.Management.System.Controller;

import com.shubham.Library.Management.System.Dto.AuthorDto;
import com.shubham.Library.Management.System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/get")
    public ResponseEntity<Page<AuthorDto>> getAllUsers(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "authorId") String sortBy
    ) {
        return new ResponseEntity<>(authorService.getAllAuthorData(pageNum - 1, pageSize, sortBy), HttpStatus.OK);
    }
}
