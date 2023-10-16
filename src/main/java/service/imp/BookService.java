package service.imp;
import entity.Book;

public interface BookService {
    Book createBook(Book book);

    Book getBookById(Long bookId);

    Book updateBook(Book book);

    void deleteBook(Long bookId);
}
