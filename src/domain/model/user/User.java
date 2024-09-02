package domain.model.user;

import domain.interfaces.ILoanChecker;
import domain.model.book.BookLoan;
import domain.model.reservation.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static domain.common.Constants.REMOVE_BOOK_RESERVATION_FROM;

public abstract class User {

    protected Logger logger = Logger.getLogger(getClass().getName());

    private Integer id;
    private String name;
    private ILoanChecker loanChecker;

    private List<BookLoan> rentedBooks = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setReservation(final Reservation reservation) {
        this.reservations.add(reservation);
    }

    public void setLoanChecker(final ILoanChecker loanChecker) {
        this.loanChecker = loanChecker;
    }

    public void setRentedBook(final BookLoan rentedBook) {

        this.getReservations().stream()
                .filter(reservation -> reservation.getBook().getId().equals(rentedBook.getBookCopy().getBookId()))
                .findFirst()
                .ifPresent(reservation -> {
                    this.getReservations().remove(reservation);
                    logger.info(REMOVE_BOOK_RESERVATION_FROM.formatted(
                            reservation.getBook().getId(), this.getName())
                    );
                });

        this.rentedBooks.add(rentedBook);
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Reservation> getReservations() {
        return this.reservations;
    }

    public ILoanChecker getLoanChecker() {
        return this.loanChecker;
    }

    public List<BookLoan> getRentedBooks() {
        return this.rentedBooks;
    }

    public Integer getTotalRentedBooks() {
        return this.rentedBooks.size();
    }

    public abstract Integer getLoanMaxDaysAllowed();

    public abstract Integer getQuantityBooksAllowed();

    public abstract Map<Boolean, String> isEligibleToRentBook();

    public boolean canBeObserver() {
        return false;
    }

    public Integer getNotifications() {
        return 0;
    }
}
