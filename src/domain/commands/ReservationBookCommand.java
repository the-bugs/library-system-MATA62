package domain.commands;

import domain.common.Params;
import domain.model.reservation.Reservation;

import static domain.common.Constants.BOOK_WAS_RESERVED_BY;
import static domain.common.Constants.USER_OR_BOOK_NOT_FOUND;

public class ReservationBookCommand extends Command {

    @Override
    public void execute(Params params) {
        final var userId = Integer.parseInt(params.getFirstKey());
        final var bookId = Integer.parseInt(params.getSecondKey());

        final var user = repository.findUserById(userId);
        final var book = repository.findBookById(bookId);

        if (book != null && user != null) {
            final var reservation = new Reservation(user, book);

            user.setReservation(reservation);
            book.setReservation(reservation);

            repository.setReservation(reservation); // "A reserva também tem que ser registrada no sistema"

            logger.info(BOOK_WAS_RESERVED_BY.formatted(book.getTitle(), user.getName()));
        } else {
            logger.info(USER_OR_BOOK_NOT_FOUND);
        }
    }
}
