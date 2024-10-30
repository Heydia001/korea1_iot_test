package org.example.springBootMainFolder.repository;

import org.example.springBootMainFolder.entity.Book;
import org.example.springBootMainFolder.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByCategory(Category category);
}