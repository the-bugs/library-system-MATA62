package domain.interfaces;

import domain.model.book.Book;

import java.util.List;

public interface IUser {

    Integer getId();

    String getName();

    Integer getLoanDaysAllowed();

    List<Book> getRentedBooks();

    Integer getQuantityBooksAllowed();

}
