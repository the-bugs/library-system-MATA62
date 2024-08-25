package domain.model.book;

import domain.interfaces.IBook;
import domain.model.reservation.Reservation;

import java.util.ArrayList;
import java.util.List;

public class Book implements IBook {

    private final Integer id;
    private final String title;
    private final String publisher;
    private final List<Author> authors;
    private final Integer edition;
    private final Integer yearPublication;

    private List<Exemplary> exemplaries = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public Book(Integer id, String title, String publisher, List<Author> authors, Integer edition, Integer yearPublication) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.authors = authors;
        this.edition = edition;
        this.yearPublication = yearPublication;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getPublisher() {
        return this.publisher;
    }

    @Override
    public List<Author> getAuthors() {
        return this.authors;
    }

    @Override
    public Integer getEdition() {
        return this.edition;
    }

    @Override
    public Integer getYearPublication() {
        return this.yearPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authors=" + authors +
                ", edition=" + edition +
                ", yearPublication=" + yearPublication +
                ", exemplaries=" + exemplaries +
                ", reservations=" + reservations +
                '}';
    }
}
