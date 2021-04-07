package com.example.demo.model;

public class Book {

	private Integer bookId;

	private String bookName;

	private Integer price;

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