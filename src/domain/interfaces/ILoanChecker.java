package domain.interfaces;

import domain.model.user.User;

public interface ILoanChecker {

    Boolean isEligibleToRentBook(final User user);

}
