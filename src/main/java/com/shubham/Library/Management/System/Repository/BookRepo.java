package com.shubham.Library.Management.System.Repository;

import com.shubham.Library.Management.System.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    boolean existsByBookTitle(String bookTitle);
}
