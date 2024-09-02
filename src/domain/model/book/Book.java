package domain.model.book;

import domain.interfaces.IObserver;
import domain.model.reservation.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Book {
    private static final Logger logger = Logger.getLogger(Book.class.getName());

    private final Integer id;
    private final String title;
    private final String publisher;
    private final List<Author> authors;
    private final Integer edition;
    private final Integer yearPublication;

    private List<BookCopy> bookCopies;
    private List<Reservation> reservations;
    private List<IObserver> observers;

    public Book(
            final Integer id,
            final String title,
            final String publisher,
            final List<Author> authors,
            final Integer edition,
            final Integer yearPublication
    ) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.authors = authors;
        this.edition = edition;
        this.yearPublication = yearPublication;
        this.bookCopies = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public List<Author> getAuthors() {
        return this.authors;
    }

    public Integer getEdition() {
        return this.edition;
    }

    public Integer getYearPublication() {
        return this.yearPublication;
    }

    public void addBookCopy(final BookCopy bookCopy) {
        this.bookCopies.add(bookCopy);
    }

    public List<BookCopy> getBookCopies() {
        return this.bookCopies;
    }

    public BookCopy getAvailableBookCopy() {
        for (final BookCopy bookCopy : bookCopies) {
            if (bookCopy.getIsAvailable()) {
                return bookCopy;
            }
        }
        return null;
    }

    public void attachObserver(IObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }

    public void setReservation(Reservation reservation) {
        this.reservations.add(reservation);
        logger.info("Added reservation. Current reservation count: " + this.reservations.size());
        if (this.reservations.size() >= 2) {
            notifyObservers();
        }
    }

    public void printObservers() {
        for (IObserver observer : observers) {
            System.out.println("Observer: " + observer);
        }
    }

    public void registerReturn(final Integer bookId) {
        for (final BookCopy bookCopy : bookCopies) {
            if (bookCopy.getBookId().equals(bookId)) {
                bookCopy.setIsAvailable(true);
                logger.info("Book copy of book with ID %d is now available.".formatted(bookCopy.getBookId()));
                break;
            }
        }
    }

    public void registerLoan(int bookId) {
        for (final BookCopy bookCopy : bookCopies) {
            if (bookCopy.getBookId().equals(bookId)) {
                bookCopy.setIsAvailable(false);
                logger.info("Book copy of book with ID %d is now unavailable.".formatted(bookCopy.getBookId()));
                break;
            }
        }
    }
}