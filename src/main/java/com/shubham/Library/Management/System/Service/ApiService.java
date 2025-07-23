package com.shubham.Library.Management.System.Service;

import com.shubham.Library.Management.System.Dto.AuthorDto;
import org.springframework.data.domain.Page;

public interface ApiService {

    Page<AuthorDto> getAllAuthorData(int pageNum,int pageSize,String sortBy);

    AuthorDto getAuthorById();

    AuthorDto createAuthorData();

    String updateAuthorData();

    String deleteAuthorData();
}
