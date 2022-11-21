package com.test.olms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id	
	@Column(name = "BOOK_ID")
	private int bookId;
	
	@Column(name = "BOOK_NAME")
	private String bookName;
	
	@Column(name = "BOOK_LOCATION")
	private String bookLocation;

	/**
	 * @return the bookid
	 */
	public int getBookid() {
		return bookId;
	}

	/**
	 * @param bookid the bookid to set
	 */
	public void setBookid(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the bookname
	 */
	public String getBookname() {
		return bookName;
	}

	/**
	 * @param bookname the bookname to set
	 */
	public void setBookname(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the bookLocation
	 */
	public String getBookLocation() {
		return bookLocation;
	}

	/**
	 * @param bookLocation the bookLocation to set
	 */
	public void setBookLocation(String bookLocation) {
		this.bookLocation = bookLocation;
	}

	

}
