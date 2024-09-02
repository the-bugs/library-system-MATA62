package repository;

import domain.model.book.Author;
import domain.model.book.Book;
import domain.model.book.BookCopy;
import domain.model.reservation.Reservation;
import domain.model.user.PostGraduateUser;
import domain.model.user.ProfessorUser;
import domain.model.user.UndergraduateUser;
import domain.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static domain.common.Constants.REPOSITORY_ADDRESS;
import static domain.common.Constants.TOTAL_OF;

public class LibraryRepository {

    private static final Logger logger = Logger.getLogger(LibraryRepository.class.getName());

    private static LibraryRepository instance;
    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();

    private final List<Integer> booksIdWithTwoCopies = List.of(100, 300, 400);
    private final List<Integer> booksIdWithOnlyOneCopy = List.of(101, 200, 201);

    private LibraryRepository() {
        this.loadData();
    }

    public static LibraryRepository getInstance() {

        if (instance == null) {
            logger.info("Creating new instance of LibraryRepository");
            instance = new LibraryRepository();
        }

        logger.info(REPOSITORY_ADDRESS.formatted(instance));
        return instance;
    }

    public Book findBookById(final Integer id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User findUserById(final Integer id) {
        return this.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void setReservation(final Reservation reservation) {
        this.reservations.add(reservation);
    }

    private void loadData() {
        initUsers();
        initBookCopies();
    }

    private void initUsers() {
        users.add(new UndergraduateUser(123, "João da Silva"));
        users.add(new PostGraduateUser(456, "Luiz Fernando Rodrigues"));
        users.add(new UndergraduateUser(789, "Pedro Paulo"));
        users.add(new ProfessorUser(100, "Carlos Lucena"));

        logger.info(TOTAL_OF.formatted("users", users.size()));
    }

    private void initBooks() {
        books.add(new Book(
                100,
                "Engenharia de Software",
                "AddisonWesley",
                List.of(new Author("Ian Sommervile")),
                6,
                2000)
        );
        books.add(new Book(
                101,
                "UML – Guia do Usuário",
                "Campus",
                List.of(
                        new Author("Grady Booch,"),
                        new Author("James Rumbaugh"),
                        new Author("Ivar Jacobson")),
                7,
                2000));
        books.add(new Book(
                200,
                "Code Complete",
                "Microsoft Press",
                List.of(new Author("Steve McConnell")),
                2,
                2014));
        books.add(new Book(
                201,
                "Agile Software Development, Principles, Patterns, and Practices",
                "Prentice Hall",
                List.of(new Author("Robert Martin")),
                1,
                2002));
        books.add(new Book(
                300,
                "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional",
                List.of(new Author("Martin Fowler")),
                1,
                1999));
        books.add(new Book(
                301,
                "Software Metrics: A Rigorous and Practical Approach",
                "CRC Press",
                List.of(new Author("Martin Fowler")),
                3,
                2014));
        books.add(new Book(
                400,
                "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional",
                List.of(new Author("Erich Gamma"),
                        new Author("Richard Helm"),
                        new Author("Ralph Johnson"),
                        new Author("John Vlissides")),
                1,
                1994));
        books.add(new Book(
                401,
                "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional",
                List.of(new Author("Marting Fowler")),
                3,
                2003));

        logger.info(TOTAL_OF.formatted("books", books.size()));
    }

    private void initBookCopies() {
        this.initBooks();

        for (final Book book : this.books) {
            int bookId = book.getId();
            int numberOfCopies = 0;

            if (booksIdWithTwoCopies.contains(bookId)) {
                numberOfCopies = 2;
            } else if (booksIdWithOnlyOneCopy.contains(bookId)) {
                numberOfCopies = 1;
            }

            for (int i = 0; i < numberOfCopies; i++) {
                book.addBookCopy(new BookCopy(book));
            }
        }

        logger.info(TOTAL_OF.formatted("book copies", this.getTotalBookCopies()));
    }

    private Integer getTotalBookCopies() {
        return books.stream()
                .mapToInt(book -> book.getBookCopies().size())
                .sum();
    }

}
