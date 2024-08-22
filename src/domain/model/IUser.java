package domain.model;

import service.IReservation;

public interface IUser {

    Integer getId();
    void setId(Integer id);
    String getName();
    void setName(String name);
    Integer getLoanDays();
    void setLoanDays(Integer loanDays);
    boolean isDebtor();
    IExemplary isBookAvailable();
    IReservation isReservationMade();

}
