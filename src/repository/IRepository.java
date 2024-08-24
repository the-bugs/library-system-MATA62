package repository;

import domain.model.book.Book;

public interface IRepository {

    Book findBookById(final Integer id);

    Object findUserById(final Integer id);
}
