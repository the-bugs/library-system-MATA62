package domain.model;

public class ProfessorUser extends User {

   Integer id;
   String name;
   Integer loanDays = 5;

    public ProfessorUser(Integer id, String name){
        this.id = id;
        this.name = name;
        this.loanDays = 7;
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
    public Integer getMaxDays() {
        return 7;
    }

}
