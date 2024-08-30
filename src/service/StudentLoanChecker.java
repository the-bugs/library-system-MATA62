package service;

import domain.interfaces.ILoanChecker;
import domain.model.book.BookLoan;
import domain.model.user.User;

import java.time.LocalDate;

public class StudentLoanChecker implements ILoanChecker {

    @Override
    public Boolean isEligibleToRentBook(final User user) {

        if (user.getRentedBooks().size() >= user.getQuantityBooksAllowed()) {
            return false;
        }

        for (final BookLoan loan : user.getRentedBooks()) {
            if (loan.getReturnDate().isBefore(LocalDate.now())) {
                return false;
            }
        }


        return true;
    }


}
