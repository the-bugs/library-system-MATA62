# Glossário

| Nome da Classe   | Descrição                 |
|------------------|---------------------------|
| Book             | Livro                     | 
| BookLoan         | Empréstimo de livro       |
| Exemplary        | Exemplar                  |
| LoanChecker      | Verificador de empréstimo |
| User             | Usuário                   |
| GraduateUser     | Aluno de graduação        |
| PostGraduateUser | Aluno de pós-graduação    |
| ProfessorUser    | Professor                 |
| Reservation      | Reserva                   |

## Nomenclaturas das Classes e seus atributos

### BookLoan :: Empréstimo de livro

Descrição: Exemplar de um livro que foi emprestado para um usuário.

| Atributo   | Descrição                                  |
|------------|--------------------------------------------|
| user       | Usuário que alugou o livro                 |
| exemplary  | Exemplar alugado                           |
| isOverdue  | Indica se o livro alugado está em atrasado |
| loanDate   | Data em que o empréstimo foi realizado     |
| returnDate | Data a ser devolvido                       |

### Exemplary :: Exemplar

Descrição: Exemplar de um livro

| Atributo    | Descrição                                                           |
|-------------|---------------------------------------------------------------------|
| exemplaryId | Identificador do exemplar, gerado incrementalmente a cada instância |
| bookLoan    | Livro alugado                                                       |
| isAvailable | Indica se o exemplar está disponível                                |

