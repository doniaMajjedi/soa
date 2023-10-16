package service.imp;

import org.springframework.stereotype.Service;

import entity.Book;
import service.imp.BookService;

import repository.BookRepository;

@Service
public class BookServiceImp implements BookService {

    private BookRepository bookRepository;
    //create
    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    //get book by id
    @Override
    public Book getBookById(Long bookId) {
        java.util.Optional<Book> optionalBook = bookRepository.findById(bookId);
        return optionalBook.get();
    }
    //update
    @Override
    public Book updateBook(Book book) {
        Book existingBook = bookRepository.findById(book.getId()).get();
        existingBook.setName(book.getName());
        existingBook.setPrice(book.getPrice());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setType(book.getType());
        Book updatedBook = bookRepository.save(existingBook);
        return updatedBook;
    }
    //delete
    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

}