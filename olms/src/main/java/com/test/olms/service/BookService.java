package com.test.olms.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.olms.entity.Book;
import com.test.olms.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}
	
	public String findByBookName(String bookname, int pagenumber) throws IOException {
		Book book = bookRepository.findByName(bookname);
		String dir = System.getProperty("user.dir");
		File file = new File(dir + book.getBookLocation());
		PDDocument doc = PDDocument.load(file);                   
		PDFTextStripper textStripper=new PDFTextStripper();
		textStripper.setStartPage(pagenumber);
		textStripper.setStartPage(pagenumber);
		String pages = textStripper.getText(doc); 
		doc.close();
		return pages;
	}
}
