package domain.model.user;

import static domain.common.Constants.GRADUATE_STUDENT_LOAN_DAYS;
import static domain.common.Constants.QUANTITY_BOOKS_GRADUATE_STUDENT;

public class GraduateUser extends User {

    public GraduateUser(final Integer id, final String name) {
        this.setId(id);
        this.setName(name);
    }

    @Override
    public Integer getLoanMaxDaysAllowed() {
        return GRADUATE_STUDENT_LOAN_DAYS;
    }

    @Override
    public Integer getQuantityBooksAllowed() {
        return QUANTITY_BOOKS_GRADUATE_STUDENT;
    }
}
