package repository;

import domain.interfaces.IBook;
import domain.model.book.Author;
import domain.model.book.Book;
import domain.model.reservation.Reservation;
import domain.model.user.GraduateUser;
import domain.model.user.PostGraduateUser;
import domain.model.user.ProfessorUser;
import domain.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibraryRepository implements IRepository {

    private static final Logger logger = Logger.getLogger(LibraryRepository.class.getName());

    private static LibraryRepository instance;
    private final List<IBook> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();

    private LibraryRepository() {
        this.loadData();
    }

    public static LibraryRepository getInstance() {
        if (instance == null) {
            instance = new LibraryRepository();
            logger.log(
                    Level.INFO,
                    "LibraryRepository instance created. Address: " + instance
            );
        }
        return instance;
    }

    @Override
    public IBook findBookById(Integer id) {
        logger.log(
                Level.INFO,
                "Find Book by ID. Repository Address: " + instance
        );
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findUserById(Integer id) {
        logger.log(
                Level.INFO,
                "Find User by ID. Repository Address: {}", instance
        );
        return this.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    private void loadData() {
        initUsers();
        initBooks();
    }

    private void initUsers() {
        users.add(new GraduateUser(123, "João da Silva"));
        users.add(new PostGraduateUser(456, "Luiz Fernando Rodrigues"));
        users.add(new GraduateUser(789, "Pedro Paulo"));
        users.add(new ProfessorUser(100, "Carlos Lucena"));
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
    }

}
