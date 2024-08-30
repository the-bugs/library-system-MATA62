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

public class LibraryRepository {

    private static final Logger logger = Logger.getLogger(LibraryRepository.class.getName());

    private static LibraryRepository instance;
    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();

    private final List<Integer> booksWithTwoCopies = List.of(100, 300, 400);
    private final List<Integer> booksWithOnlyOneCopy = List.of(101, 200, 201);

    private LibraryRepository() {
        this.loadData();
    }

    public static LibraryRepository getInstance() {

        if (instance == null) {
            instance = new LibraryRepository();
            logger.info("LibraryRepository instance created. Address: " + instance);
        }

        logger.info("LibraryRepository address: " + instance);
        return instance;
    }

    public Book findBookById(final Integer id) {
        logger.info("Finding Book by ID. Repository Address: " + instance);

        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User findUserById(final Integer id) {
        logger.info("Finding User by ID. Repository Address: " + instance);

        return this.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addReservation(final Reservation reservation) {
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

        logger.info("Total of users: " + users.size());
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

        logger.info("Total of books: " + books.size());
    }

    private void initBookCopies() {
        this.initBooks();

        for (final Book book : this.books) {
            int bookId = book.getId();
            int numberOfCopies = 0;

            if (booksWithTwoCopies.contains(bookId)) {
                numberOfCopies = 2;
            } else if (booksWithOnlyOneCopy.contains(bookId)) {
                numberOfCopies = 1;
            }

            for (int i = 0; i < numberOfCopies; i++) {
                book.addBookCopy(new BookCopy(book));
            }
        }

        logger.info("Total of book copies: " + this.getTotalBookCopies());
    }

    private Integer getTotalBookCopies() {
        return books.stream()
                .mapToInt(book -> book.getBookCopies().size())
                .sum();
    }

}
