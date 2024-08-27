package domain.model.user;

import domain.interfaces.ILoanChecker;
import domain.model.book.BookLoan;

import java.time.LocalDate;
import java.util.List;

public abstract class User implements ILoanChecker {

    private Integer id;
    private String name;
    private List<BookLoan> rentedBooks;

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void addBookLoan(final BookLoan bookLoan) {
        this.rentedBooks.add(bookLoan);
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<BookLoan> getRentedBooks() {
        return this.rentedBooks;
    }

    public abstract Integer getLoanMaxDaysAllowed();

    public abstract Integer getQuantityBooksAllowed();

    @Override
    public Boolean isLoanOverdue() {
        for (final BookLoan loan : this.rentedBooks) {
            if (loan.getReturnDate().isBefore(LocalDate.now())) {
                loan.setIsOverdue(true);
                return true;
            }
        }
        return false;
    }
}
