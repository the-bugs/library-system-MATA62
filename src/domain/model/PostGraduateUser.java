package domain.model;

import service.IReservation;

public class PostGraduateUser extends UserStudent {

    private Integer id;
    private String name;
    private Integer loanDays;
    private Integer bookQuantity;

    public PostGraduateUser(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.loanDays = 5;
        this.bookQuantity = 4;
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
    public Integer getMaxDays() {
        return 5;
    }

}
