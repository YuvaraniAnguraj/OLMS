package com.test.olms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.olms.entity.Book;
import com.test.olms.service.BookService;

@RestController
@RequestMapping("/Book")
public class BookController {

	@Autowired
	BookService bookservice;
	
	@GetMapping("/test")
	public String test() {
		return "Test";
	}
	
	@GetMapping("/getAllBook")
	public ResponseEntity<List<Book>> getAllBook() {
		List<Book> bookList =bookservice.getAllBook();
		if (bookList == null) {
			return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
	}
	
	@GetMapping("/getBookWithPagenumber/{bookname}/{pagenumber}")
	public ResponseEntity<String> getBookWithPagenumber(@PathVariable("bookname")  String bookname,
			@PathVariable("pagenumber") int pagenumber) throws IOException {
		String bookContent = bookservice.findByBookName(bookname, pagenumber);
		if (bookContent == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(bookContent, HttpStatus.OK);
	}

}
