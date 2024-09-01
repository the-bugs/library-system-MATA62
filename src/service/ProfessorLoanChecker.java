package service;

import domain.interfaces.ILoanChecker;
import domain.model.user.User;

import java.util.Map;

public class ProfessorLoanChecker implements ILoanChecker {

    @Override
    public Map<Boolean, String> isEligibleToRentBook(User user) {
        return Map.of();
    }
}
