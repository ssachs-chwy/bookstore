package com.chewy.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.chewy.bookstore.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}