package domain.model.user;

import static domain.common.Constants.PROFESSOR_LOAN_DAYS;
import static domain.common.Constants.QUANTITY_BOOKS_PROFESSOR;

public class ProfessorUser extends User {

    public ProfessorUser(Integer id, String name) {
        this.setId(id);
        this.setName(name);
    }

    @Override
    public Integer getLoanMaxDaysAllowed() {
        return PROFESSOR_LOAN_DAYS;
    }

    @Override
    public Integer getQuantityBooksAllowed() {
        return QUANTITY_BOOKS_PROFESSOR;
    }
}
