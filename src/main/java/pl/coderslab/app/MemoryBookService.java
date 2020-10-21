package pl.coderslab.app;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemoryBookService implements BookService{
    private List<Book> list;
    private static Long nextId = 4L;

    public MemoryBookService() {

        list = new ArrayList<>();

        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));

        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion","programming"));

        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion","programming"));

    }

    public List<Book> getList() {
        return list;
    }

    public static Long getNextId() {
        return nextId;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public static void setNextId(Long nextId) {
        MemoryBookService.nextId = nextId;
    }

    @Override
    public List<Book> getBooks() {
     return list;
    }

    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        list.add(book);
    }

    @Override
    public void deleteBook(Long id) {
      list.remove(get(id).get());

    }


    @Override
    public Optional<Book> get(Long id) {
       return list.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    @Override
    public void updateBook(Long id, Book book) {
        deleteBook(id);
        addBook(book);
    }
}
