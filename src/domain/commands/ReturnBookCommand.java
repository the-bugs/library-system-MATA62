package domain.commands;

import domain.common.Params;

public class ReturnBookCommand extends Command {

    @Override
    public void execute(Params params) {

        final var userId = Integer.parseInt(params.getFirstKey());
        final var bookId = Integer.parseInt(params.getSecondKey());
        final var user = repository.findUserById(userId);
        final var book = repository.findBookById(bookId);

        if (book != null && user != null) {
            user.getRentedBooks().stream()
                    .filter(bookLoan -> bookLoan.getBookCopy().getBookId().equals(bookId))
                    .findFirst()
                    .ifPresent(bookLoan -> {
                        user.getRentedBooks().remove(bookLoan);
                        logger.info("Book returned by " + user.getName());
                    });
        } else {
            logger.info("User or book not found");
        }
    }
}
