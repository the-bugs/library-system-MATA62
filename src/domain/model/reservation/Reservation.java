package domain.model.reservation;

import domain.interfaces.IBook;
import domain.model.book.Book;
import domain.model.user.User;

import java.time.LocalDate;

public class Reservation {

    private User user;
    private IBook book;
    private final LocalDate reservationDate;

    public Reservation(final User user, final IBook book) {
        this.user = user;
        this.book = book;
        this.reservationDate = LocalDate.now();
    }

    public IBook getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getReservationDate() {
        return this.reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "book=" + book +
                ", user=" + user +
                ", reservationDate=" + reservationDate +
                '}';
    }
}
