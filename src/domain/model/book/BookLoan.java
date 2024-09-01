package domain.model.book;

import domain.model.user.User;

import java.time.LocalDate;

public class BookLoan {

    private User user;
    private BookCopy bookCopy;
    private final LocalDate loanDate;
    private final LocalDate returnDate;

    public BookLoan(final User user, final BookCopy bookCopy) {
        this.user = user;
        this.bookCopy = bookCopy;

        // TODO: Esta data deve ser alterada após os testes de atraso.
        this.loanDate = LocalDate.of(2021, 1, 1);
        this.returnDate = this.loanDate.plusDays(this.user.getLoanMaxDaysAllowed());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
}
