package pl.coderslab.app;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();
    void addBook(Book Book);
    void deleteBook (Long id);
    Optional<Book> get(Long id);
    void updateBook (Long id, Book book);
}
