package domain.model.reservation;

import domain.interfaces.IBook;
import domain.interfaces.IReservation;
import domain.model.book.Book;
import domain.model.user.User;

import java.time.LocalDate;

public class Reservation implements IReservation {

    private User user;
    private IBook book;
    private final LocalDate reservationDate;

    public Reservation(final User user, final IBook book) {
        this.user = user;
        this.book = book;
        this.reservationDate = LocalDate.now();
    }

    @Override
    public IBook getBook() {
        return book;
    }

    @Override
    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
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
