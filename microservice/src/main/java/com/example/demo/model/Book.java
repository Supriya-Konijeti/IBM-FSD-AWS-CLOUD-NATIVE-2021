package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private Integer bookId;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "book_price")
	private Integer price;
	@Column(name = "author_name")
	private String authorName;
	public Book() {
		super();
	}
	public Book(Integer bookId, String bookName, Integer price, String authorName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.authorName = authorName;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	

}