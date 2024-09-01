package domain.model.book;

import domain.model.reservation.Reservation;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private final Integer id;
    private final String title;
    private final String publisher;
    private final List<Author> authors;
    private final Integer edition;
    private final Integer yearPublication;

    private List<BookCopy> bookCopies;
    private List<Reservation> reservations;

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
        return this.bookCopies.stream()
                .filter(BookCopy::getIsAvailable)
                .findFirst()
                .orElse(null);
    }
}