package com.codingdojo.bookclub.repoitories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
	List<Book> findByBorrower(User borrower);
	 @Query("SELECT b FROM Book b WHERE b.borrower IS NULL OR b.borrower <> :borrower")
	    List<Book> findByBorrowerIsNullOrNot(@Param("borrower") User borrower);
}
