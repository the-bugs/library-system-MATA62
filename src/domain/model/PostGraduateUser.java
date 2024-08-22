package domain.model;

import service.IReservation;

public class PostGraduateUser implements  IUser, IBookQuantityPerStudent {

    Integer id;
    String name;
    Integer loanDays;
    private Integer bookQuantity;



    public PostGraduateUser(Integer id, String name){
        this.id = id;
        this.name = name;
        this.loanDays = 5;
        this.bookQuantity = 4;
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getLoanDays() {
        return null;
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
