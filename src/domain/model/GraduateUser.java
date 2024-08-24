package domain.model;

import service.IReservation;

public class GraduateUser extends UserStudent {

    private Integer id;
    private String name;
    private Integer loanDays;
    private Integer bookQuantity;

    public GraduateUser(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.loanDays = 3;  // Definido como 3 dias de empréstimo
        this.bookQuantity = 3;  // Definido como 3 livros permitidos
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
        return 3;
    }

}
