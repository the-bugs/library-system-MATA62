package domain.interfaces;

import domain.model.user.User;

import java.util.Map;

public interface ILoanChecker {

    Map<Boolean, String> isEligibleToRentBook(final User user);

}
