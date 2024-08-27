package domain.commands;

import domain.common.Params;
import domain.model.reservation.Reservation;

public class ReservationBookCommand extends Command {

    @Override
    public void execute(Params params) {
        final Integer userId = Integer.parseInt(params.getFirstKey());
        final Integer bookId = Integer.parseInt(params.getSecondKey());

        final var user = repository.findUserById(userId);
        final var book = repository.findBookById(bookId);

        if (book != null && user != null) {
            final Reservation reservation = new Reservation(user, book);
            repository.addReservation(reservation);
            logger.info("Reservation created: " + reservation);
            book.getReservations().add(reservation);
            logger.info(book.getTitle() + " was reserved by user " + user.getName());
        } else {
            logger.info("Book or User not found.");
        }
    }
}
