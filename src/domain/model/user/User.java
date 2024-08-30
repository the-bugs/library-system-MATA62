package domain.model.user;

import domain.interfaces.ILoanChecker;
import domain.model.book.BookLoan;

import java.util.ArrayList;
import java.util.List;

public abstract class User {

    private Integer id;
    private String name;
    private ILoanChecker loanChecker;
    private List<BookLoan> rentedBooks = new ArrayList<>();

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setLoanChecker(final ILoanChecker loanChecker) {
        this.loanChecker = loanChecker;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public ILoanChecker getLoanChecker() {
        return this.loanChecker;
    }

    public void addBookLoan(final BookLoan bookLoan) {
        this.rentedBooks.add(bookLoan);
    }

    public List<BookLoan> getRentedBooks() {
        return this.rentedBooks;
    }

    public abstract Integer getLoanMaxDaysAllowed();

    public abstract Integer getQuantityBooksAllowed();

    public abstract Boolean isEligibleToRentBook();
}
