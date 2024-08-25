package domain.interfaces;

import domain.model.book.Book;

import java.util.List;

public interface IUser {

    Integer getId();

    String getName();

    Integer getLoanMaxDaysAllowed();

    List<Book> getRentedBooks();

    Integer getQuantityBooksAllowed();

}
