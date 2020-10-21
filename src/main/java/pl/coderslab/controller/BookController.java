package pl.coderslab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.app.Book;
import pl.coderslab.app.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Book> getBook() {
        return bookService.getBooks();
    }

    @PostMapping("")
    @ResponseBody
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Book getBook(@PathVariable Long id) {
        return this.bookService.get(id).orElseThrow(() -> {
                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "entity not found"
                    );
                }
        );
    }

    @PutMapping("/{id}")
    @ResponseBody
    public void updateBook(@PathVariable Long id, @RequestBody Book book){
        bookService.updateBook(id, book);
    }
}
