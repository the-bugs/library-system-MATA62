package domain.model.user;

import domain.interfaces.IObserver;
import service.ProfessorLoanChecker;

import java.util.Map;

import static domain.common.Constants.PROFESSOR_LOAN_DAYS;
import static domain.common.Constants.QUANTITY_BOOKS_PROFESSOR;

public class ProfessorUser extends User implements IObserver {

    private Integer notifications = 0;

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
    public Map<Boolean, String> isEligibleToRentBook() {
        return this.getLoanChecker()
                .isEligibleToRentBook(this);
    }

    @Override
    public void update() {
        notifications++;
        System.out.println("Notification count for " + this.getName() + ": " + notifications);
    }

    @Override
    public Integer getNotifications() {
        return notifications;
    }

    @Override
    public boolean canBeObserver(){
        return true;
    }

}
