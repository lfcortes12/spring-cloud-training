package com.glb.training.bookstorems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glb.training.bookstorems.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	Book findByIsbn(String isbn);

}
