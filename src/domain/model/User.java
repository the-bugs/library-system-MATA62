package domain.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public abstract class User {

    private Integer id;
    private String name;
    private Integer loanDays;
    private List<Object> loans;

    // Função para verificar a quantidade de dias máximos de um emprestimo
    public abstract Object getMaxDays();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Trocar para objeto de emprestimos
    public List<Object> getLoans() {
        return loans;
    }

    public Integer getLoanDays() {
        return loanDays;
    }

    public void setLoanDays(Integer loanDays) {
        this.loanDays = loanDays;
    }

    // Função para verificar se o usuário está devendo livros?


}
