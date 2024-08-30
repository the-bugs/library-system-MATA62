package domain.model.user;

import service.ProfessorLoanChecker;

import static domain.common.Constants.PROFESSOR_LOAN_DAYS;
import static domain.common.Constants.QUANTITY_BOOKS_PROFESSOR;

public class ProfessorUser extends User {

    public ProfessorUser(Integer id, String name) {
        this.setId(id);
        this.setName(name);
        this.setLoanChecker(new ProfessorLoanChecker());
    }

    @Override
    public Integer getLoanMaxDaysAllowed() {
        return PROFESSOR_LOAN_DAYS;
    }

    @Override
    public Integer getQuantityBooksAllowed() {
        return QUANTITY_BOOKS_PROFESSOR;
    }

    @Override
    public Boolean isEligibleToRentBook() {
        return null;
    }
}
