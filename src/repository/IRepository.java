package repository;

import domain.interfaces.IBook;
import domain.model.user.User;

public interface IRepository {

    IBook findBookById(final Integer id);

    User findUserById(final Integer id);
}
