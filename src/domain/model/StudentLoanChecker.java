package domain.model;

public class StudentLoanChecker implements  ILoanChecker{

    @Override
    public boolean check(User user){
        for (Object loan : user.getLoans()) {
            // trocar para checar se a data atual do emprestimo
            // é antes da data de entrega do emprestimo
            if (loan.equals(1)) {
                return true;
            }
        }
        return false;
    }
}

