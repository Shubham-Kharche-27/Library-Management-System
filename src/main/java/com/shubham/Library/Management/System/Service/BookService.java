package com.shubham.Library.Management.System.Service;

import com.shubham.Library.Management.System.Dto.BookDto;
import com.shubham.Library.Management.System.Dto.CategoryDto;
import com.shubham.Library.Management.System.Entity.Author;
import com.shubham.Library.Management.System.Entity.Book;
import com.shubham.Library.Management.System.Entity.Category;
import com.shubham.Library.Management.System.Entity.Publisher;
import com.shubham.Library.Management.System.Exception.*;
import com.shubham.Library.Management.System.Repository.AuthorRepo;
import com.shubham.Library.Management.System.Repository.BookRepo;
import com.shubham.Library.Management.System.Repository.CategoryRepo;
import com.shubham.Library.Management.System.Repository.PublisherRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private PublisherRepo publisherRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public Page<BookDto> getAllBookData(int pageNum, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        Page<Book> bookPage = bookRepo.findAll(pageable);
        return bookPage.map(Book -> modelMapper.map(Book, BookDto.class));
    }

    public BookDto getBookDataById(long bookId) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book does not exits!"));
        return modelMapper.map(book, BookDto.class);
    }

    public String createBookData(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        if(!bookRepo.existsByBookTitle(bookDto.getBookTitle())){
            Author author = authorRepo.findById(bookDto.getAuthorId())
                    .orElseThrow(() -> new AuthorNotFoundException("Author does not exist!"));
            Publisher publisher = publisherRepo.findById(bookDto.getPublisherId())
                    .orElseThrow(() -> new PublisherNotFoundException("Publisher does not exist!"));
            List<Category> categoryList = new ArrayList<>();
            for (CategoryDto categoryDto : bookDto.getCategories()) {
                Category category = categoryRepo.findById(categoryDto.getCategoryId())
                        .orElseThrow(() -> new CategoryNotFoundException("Category does not exist!"));
                categoryList.add(category);
            }
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.setCategories(categoryList);
            modelMapper.map(bookRepo.save(book), BookDto.class);
        }else{
            throw new BookExistException("Book with this title already exists");
        }
        return "Book created successfully!";
    }

    public String updateBookData(long bookId, BookDto bookDto) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book does not exist!"));
        if (bookDto.getBookTitle() != null) {
            book.setBookTitle(bookDto.getBookTitle());
        }
        if (bookDto.getPublicationDate() != null) {
            book.setPublicationDate(bookDto.getPublicationDate());
        }
        bookRepo.save(book);
        return "Book data updated successfully!";
    }

    public String deleteBookData(long bookId) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book does not exist!"));
        bookRepo.delete(book);
        return "Book deleted successfully!";
    }
}
