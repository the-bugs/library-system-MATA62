package domain.model.user;

import domain.interfaces.IUndergraduateUser;
import domain.model.book.Book;

import java.util.ArrayList;
import java.util.List;

import static domain.common.Constants.QUANTITY_BOOKS_UNDERGRADUATE_STUDENT;
import static domain.common.Constants.UNDERGRADUATE_STUDENT_LOAN_DAYS;

public class UndergraduateUser implements IUndergraduateUser {

    private final Integer id;
    private final String name;
    private final List<Book> rentedBooks = new ArrayList<>();

    public UndergraduateUser(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getLoanDaysAllowed() {
        return UNDERGRADUATE_STUDENT_LOAN_DAYS;
    }

    @Override
    public List<Book> getRentedBooks() {
        return this.rentedBooks;
    }

    @Override
    public Integer getQuantityBooksAllowed() {
        return QUANTITY_BOOKS_UNDERGRADUATE_STUDENT;
    }
}
