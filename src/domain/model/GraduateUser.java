package domain.model;

import service.IReservation;

public class GraduateUser implements IUserStudent{

    Integer id;
    String name;
    private Integer loanDays;
    private Integer bookQuantity;

    public GraduateUser(Integer id, String name){
        this.id = id;
        this.name = name;
        this.loanDays = 3;
        this.bookQuantity = 3;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getLoanDays() {
        return this.loanDays;
    }

    @Override
    public void setLoanDays(Integer loanDays) {
        this.loanDays = loanDays;
    }

    @Override
    public boolean isDebtor() {
        return false;
    }

    @Override
    public IExemplary isBookAvailable() {
        return null;
    }

    @Override
    public IReservation isReservationMade() {
        return null;
    }


    @Override
    public Integer getBookQuantity() {
        return this.bookQuantity;
    }
}
