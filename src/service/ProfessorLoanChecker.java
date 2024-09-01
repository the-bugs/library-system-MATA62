package service;

import domain.interfaces.ILoanChecker;
import domain.model.book.BookLoan;
import domain.model.user.User;

import java.time.LocalDate;
import java.util.Map;

import static domain.common.Constants.USER_HAS_OVERDUE_BOOKS;

public class ProfessorLoanChecker implements ILoanChecker {

    @Override
    public Map<Boolean, String> isEligibleToRentBook(User user) {

        for(BookLoan loan : user.getRentedBooks()) {
            if(loan.getReturnDate().isBefore(LocalDate.now()) ) {
                return Map.of(
                        false,
                        USER_HAS_OVERDUE_BOOKS.formatted(user.getName())
                );
            }
        }

        return Map.of(true, "SUCCESS");
    }
}
