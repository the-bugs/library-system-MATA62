package domain.model.reservation;

import domain.interfaces.IUser;
import domain.model.book.Book;

import java.time.LocalDate;

public class Reservation {

    private Book book;
    private IUser user;
    private LocalDate reservationDate;

    public Reservation(final Book book, final IUser user) {
        this.book = book;
        this.user = user;
        this.reservationDate = LocalDate.now();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
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
