package com.test.olms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.olms.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("SELECT b FROM Book b WHERE b.bookName = :name")
	public Book findByName(@Param("name") String name);
}
