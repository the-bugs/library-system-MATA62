package domain.commands;

import domain.common.Params;
import domain.model.book.BookLoan;

import static domain.common.Constants.USER_OR_BOOK_NOT_FOUND;

public class LoanBookCommand extends Command {

    @Override
    public void execute(Params params) {
        final Integer userId = Integer.parseInt(params.getFirstKey());
        final Integer bookId = Integer.parseInt(params.getSecondKey());

        final var user = repository.findUserById(userId);

        if (Boolean.TRUE.equals(user.isEligibleToRentBook())) {
            logger.info("OK");
        } else {
            logger.info("User is not eligible to rent a book");
            return;
        }

        final var book = repository.findBookById(bookId);

        if (book == null || user == null) {
            logger.info(USER_OR_BOOK_NOT_FOUND);
        } else {
            final var exemplary = book
                    .getBookCopies()
                    .stream()
                    .filter(e -> e.getStatus()).findFirst()
                    .orElse(null);

            if (exemplary == null) {
                logger.info("There are no available exemplaries for this book");
                return;
            }

            final var bookLoan = new BookLoan(user, exemplary);
            exemplary.setStatus(false);

            user.addBookLoan(bookLoan);
            logger.info(String.format("The book %s was rented by %s", book.getTitle(), user.getName()));
        }
    }
}
