package domain.model.book;

import domain.interfaces.IExemplary;
import domain.interfaces.IUser;

import java.time.LocalDate;

public class BookLoan {

    private IUser user;
    private IExemplary exemplary;
    private Boolean isOverdue;
    private final LocalDate loanDate;
    private final LocalDate returnDate;

    public BookLoan(final IUser user, final IExemplary exemplary) {
        this.user = user;
        this.exemplary = exemplary;
        this.loanDate = LocalDate.of(2021, 1, 1); // TODO: Esta data deve ser alterada após os testes de atraso.
        this.returnDate = this.loanDate.plusDays(this.user.getLoanMaxDaysAllowed());
    }

    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }

    public IExemplary getExemplary() {
        return exemplary;
    }

    public void setExemplary(IExemplary exemplary) {
        this.exemplary = exemplary;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public Boolean getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(Boolean isOverdue) {
        this.isOverdue = isOverdue;
    }
}
