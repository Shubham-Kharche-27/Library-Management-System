package com.shubham.Library.Management.System.Service;

import com.shubham.Library.Management.System.Dto.AuthorDto;
import com.shubham.Library.Management.System.Entity.Author;
import com.shubham.Library.Management.System.Repository.AuthorRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements ApiService{

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Page<AuthorDto> getAllAuthorData(int pageNum, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum,pageSize, Sort.by(sortBy));
        Page<Author> authorPage = authorRepo.findAll(pageable);
        return authorPage.map(Author->modelMapper.map(Author,AuthorDto.class));
    }

    @Override
    public AuthorDto getAuthorById() {
        return null;
    }

    @Override
    public AuthorDto createAuthorData() {
        return null;
    }

    @Override
    public String updateAuthorData() {
        return "";
    }

    @Override
    public String deleteAuthorData() {
        return "";
    }
}
