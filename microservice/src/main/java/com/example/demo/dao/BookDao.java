package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;
@Repository
public interface BookDao extends JpaRepository<Book, Integer>{
	@Query
	public List<Book> findByAuthorName(String authorName);

}