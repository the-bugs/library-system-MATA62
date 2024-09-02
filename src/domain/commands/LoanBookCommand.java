package domain.commands;

import domain.common.Params;
import domain.model.book.BookLoan;

import static domain.common.Constants.*;

public class LoanBookCommand extends Command {

    @Override
    public void execute(Params params) {
        final var userId = Integer.parseInt(params.getFirstKey());
        final var bookId = Integer.parseInt(params.getSecondKey());

        final var user = repository.findUserById(userId);
        final var book = repository.findBookById(bookId);

        if (user == null || book == null) {
            logger.info(USER_OR_BOOK_NOT_FOUND);
            return;
        }

        final var result = user.isEligibleToRentBook();

        if (result.containsKey(false)) {
            final var reason = result.get(false);
            logger.info(USER_IS_NOT_ELIGIBLE_TO_RENT_BOOK.formatted(user.getName(), reason));
        } else {

            final var bookCopy = book.getAvailableBookCopy();
            if (bookCopy == null) {
                logger.info(NO_AVAILABLE_COPIES_OF_BOOK.formatted(book.getTitle()));
            } else {
                user.setRentedBook(new BookLoan(user, bookCopy));
                logger.info(BOOK_WAS_RENTED_BY.formatted(book.getTitle(), user.getName()));
                book.registerLoan(bookCopy);
            }
        }
    }

}
