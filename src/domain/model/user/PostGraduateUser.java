package domain.model.user;

import static domain.common.Constants.POSTGRADUATE_STUDENT_LOAN_DAYS;
import static domain.common.Constants.QUANTITY_BOOKS_POSTGRADUATE_STUDENT;

public class PostGraduateUser extends User {

    public PostGraduateUser(final Integer id, final String name) {
        this.setId(id);
        this.setName(name);
    }

    @Override
    public Integer getLoanMaxDaysAllowed() {
        return POSTGRADUATE_STUDENT_LOAN_DAYS;
    }

    @Override
    public Integer getQuantityBooksAllowed() {
        return QUANTITY_BOOKS_POSTGRADUATE_STUDENT;
    }


}
