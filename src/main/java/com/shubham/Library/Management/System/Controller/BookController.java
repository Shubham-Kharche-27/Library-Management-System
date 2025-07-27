package com.shubham.Library.Management.System.Controller;

import com.shubham.Library.Management.System.Dto.BookDto;
import com.shubham.Library.Management.System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/get")
    public ResponseEntity<Page<BookDto>> getAllBookData(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "bookId") String sortBy
    ) {
        return new ResponseEntity<>(bookService.getAllBookData(pageNum - 1, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping("/get/byId/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable long bookId) {
        return new ResponseEntity<>(bookService.getBookDataById(bookId), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createBook(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.createBookData(bookDto), HttpStatus.CREATED);
    }

    @PutMapping("/put/{bookId}")
    public ResponseEntity<String> updateBookD(@PathVariable long bookId, @RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.updateBookData(bookId, bookDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable long bookId) {
        return new ResponseEntity<>(bookService.deleteBookData(bookId), HttpStatus.NO_CONTENT);
    }
}
