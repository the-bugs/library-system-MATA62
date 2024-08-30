package domain.interfaces;

import domain.model.book.Book;
import domain.model.user.User;

import java.time.LocalDate;

public interface IReservation {

    Book getBook();

    void setBook(Book book);

    User getUser();

    void setUser(User user);

    LocalDate getReservationDate();
}
