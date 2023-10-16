package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import entity.Book;
import service.imp.BookService;

import repository.BookRepository;

@Controller
public class BookController {
    private BookService bookService;
    BookRepository bookRepository;

    //build create book rest api
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book savedbook = bookService.createBook(book);
        return new ResponseEntity<>(savedbook, HttpStatus.CREATED);
    }

    //get book by id
    @PostMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long bookId){
        Book book = bookService.getBookById(bookId);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    // Build Update Book REST API
    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long bookId,
                                           @RequestBody Book book){
        book.setId(bookId);
        Book upBook = bookService.updateBook(book);
        return new ResponseEntity<>(upBook, HttpStatus.OK);
    }
    // Build Delete Book REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long bookId){
        bookService.deleteBook(bookId);
        return new ResponseEntity<>("Book successfully deleted!", HttpStatus.OK);
    }
}