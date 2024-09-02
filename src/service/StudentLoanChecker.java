package service;

import domain.interfaces.ILoanChecker;
import domain.model.book.BookLoan;
import domain.model.user.User;

import java.time.LocalDate;
import java.util.Map;
import java.util.logging.Logger;

import static domain.common.Constants.USER_HAS_OVERDUE_BOOKS;
import static domain.common.Constants.USER_REACHED_MAXIMUM_BOOKS_ALLOWED;

public class StudentLoanChecker implements ILoanChecker {

    protected Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public Map<Boolean, String> isEligibleToRentBook(final User user) {

        if (user.getTotalRentedBooks() >= user.getQuantityBooksAllowed()) {
            return Map.of(
                    false,
                    USER_REACHED_MAXIMUM_BOOKS_ALLOWED.formatted(user.getName(), user.getQuantityBooksAllowed())
            );
        }

        for (final BookLoan loan : user.getRentedBooks()) {
            if (loan.getReturnDate().isBefore(LocalDate.now())) {
                return Map.of(
                        false,
                        USER_HAS_OVERDUE_BOOKS.formatted(user.getName())
                );
            }
        }

        return Map.of(true, "SUCCESS");
    }

}
