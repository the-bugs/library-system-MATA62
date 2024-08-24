package domain.model.book;

import domain.interfaces.IUser;

import java.time.LocalDate;

public class BookLoan {

    private IUser user;
    private BookCopy copy;
    private LocalDate loanDate = LocalDate.now();
    private LocalDate returnDate;

    public BookLoan(IUser u) {
        returnDate.plusDays(u.getLoanDaysAllowed());

    }

}
