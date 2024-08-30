package service;

import domain.interfaces.ILoanChecker;
import domain.model.user.User;

public class ProfessorLoanChecker implements ILoanChecker {

    @Override
    public Boolean isEligibleToRentBook(User user) {
        return null;
    }
}
