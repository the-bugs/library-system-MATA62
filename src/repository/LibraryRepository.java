package repository;

import domain.model.Author;
import domain.model.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepository implements IRepository {

    private static LibraryRepository instance;
    private final List<Book> books = new ArrayList<>();

    private LibraryRepository() {
        this.loadData();
    }

    public static LibraryRepository getInstance() {
        if (instance == null) {
            instance = new LibraryRepository();
        }
        return instance;
    }

    private void loadData() {
        books.add(new Book(
                100,
                "Engenharia de Software",
                "AddisonWesley",
                List.of(new Author("Ian Sommervile")),
                6,
                2000)
        );
        books.add(new Book(101, "UML – Guia do Usuário", "Campus",
                List.of(new Author("Grady Booch,"), new Author("James Rumbaugh"), new Author("Ivar Jacobson")),
                7, 2000));
        books.add(new Book(200, "Code Complete", "Microsoft Press",
                List.of(new Author("Steve McConnell")), 2, 2014));
        books.add(new Book(201, "Agile Software Development, Principles, Patterns, and Practices",
                "Prentice Hall", List.of(new Author("Robert Martin")), 1, 2002));
        books.add(new Book(300, "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional", List.of(new Author("Martin Fowler")), 1, 1999));
        books.add(new Book(301, "Software Metrics: A Rigorous and Practical Approach",
                "CRC Press", List.of(new Author("Martin Fowler")), 3, 2014));
        books.add(new Book(400, "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", List.of(new Author("Erich Gamma"), new Author("Richard Helm")
                , new Author("Ralph Johnson"), new Author("John Vlissides")), 1, 1994));
        books.add(new Book(401, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional", List.of(new Author("Marting Fowler")), 3, 2003));

    }

    @Override
    public Book findBookById(Integer id) {
        return books.stream()
                .filter(book -> book.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Object findUserById(Integer id) {
        return null;
    }
}
