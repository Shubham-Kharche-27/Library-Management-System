package com.shubham.Library.Management.System.Controller;

import com.shubham.Library.Management.System.Dto.AuthorDto;
import com.shubham.Library.Management.System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get/byId/{authorId}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable long authorId){
        return new ResponseEntity<>(authorService.getAuthorById(authorId),HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        return new ResponseEntity<>(authorService.createAuthorData(authorDto),HttpStatus.CREATED);
    }

    @PutMapping("/put/{authorId}")
    public ResponseEntity<String> updateAuthor(@PathVariable long authorId,@RequestBody AuthorDto authorDto){
        return new ResponseEntity<>(authorService.updateAuthorData(authorId,authorDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{authorId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable long authorId){
        return new ResponseEntity<>(authorService.deleteAuthorData(authorId),HttpStatus.NO_CONTENT);
    }
}
