package domain.model.user;

import service.StudentLoanChecker;

import static domain.common.Constants.GRADUATE_STUDENT_LOAN_DAYS;
import static domain.common.Constants.QUANTITY_BOOKS_GRADUATE_STUDENT;

public class UndergraduateUser extends User {

    public UndergraduateUser(final Integer id, final String name) {
        this.setId(id);
        this.setName(name);
        this.setLoanChecker(new StudentLoanChecker());
    }

    @Override
    public Integer getLoanMaxDaysAllowed() {
        return GRADUATE_STUDENT_LOAN_DAYS;
    }

    @Override
    public Integer getQuantityBooksAllowed() {
        return QUANTITY_BOOKS_GRADUATE_STUDENT;
    }

    @Override
    public Boolean isEligibleToRentBook() {
        return this.getLoanChecker()
                .isEligibleToRentBook(this);
    }

}
