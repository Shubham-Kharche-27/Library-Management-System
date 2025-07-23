package com.shubham.Library.Management.System.Service;

import com.shubham.Library.Management.System.Dto.AuthorDto;
import com.shubham.Library.Management.System.Entity.Author;
import com.shubham.Library.Management.System.Exception.AuthorNotFoundException;
import com.shubham.Library.Management.System.Repository.AuthorRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private ModelMapper modelMapper;


    public Page<AuthorDto> getAllAuthorData(int pageNum, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        Page<Author> authorPage = authorRepo.findAll(pageable);
        return authorPage.map(Author -> modelMapper.map(Author, AuthorDto.class));
    }


    public AuthorDto getAuthorById(long authorId) {
        Author author = authorRepo.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException("Author does not exist!"));
        return modelMapper.map(author, AuthorDto.class);
    }


    public AuthorDto createAuthorData(AuthorDto authorDto) {
        Author author = modelMapper.map(authorDto,Author.class);
        return modelMapper.map(authorRepo.save(author),AuthorDto.class);
    }


    public String updateAuthorData(long authorId,AuthorDto authorDto) {
        Author author = authorRepo.findById(authorId)
                .orElseThrow(()->new AuthorNotFoundException("Author does not exist!"));
        if(authorDto.getAuthorName()!=null){
            author.setAuthorName(authorDto.getAuthorName());
        }
        if(authorDto.getAuthorBiography()!=null){
            author.setAuthorBiography(authorDto.getAuthorBiography());
        }
        if(authorDto.getAuthorDob()!=null){
            author.setAuthorDob(authorDto.getAuthorDob());
        }
        modelMapper.map(authorRepo.save(author),AuthorDto.class);
        return "Author updated successfully!";
    }


    public String deleteAuthorData(long authorId) {
        Author author = authorRepo.findById(authorId)
                .orElseThrow(()->new AuthorNotFoundException("Author does not exist!"));
        authorRepo.deleteById(authorId);
        return "Author deleted successfully!";
    }
}
