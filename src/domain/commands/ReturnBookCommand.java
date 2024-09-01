package domain.commands;

import domain.common.Params;

public class ReturnBookCommand extends Command {

    @Override
    public void execute(Params params) {

        final var userId = Integer.parseInt(params.getFirstKey());
        final var bookId = Integer.parseInt(params.getSecondKey());
        final var user = repository.findUserById(userId);
        final var book = repository.findBookById(bookId);

        if(user == null || book == null) {
            logger.info("User or book not found");
            return;
        }

        user.getRentedBooks().stream()
            .filter(bookLoan -> bookLoan.getBookCopy().getBookId().equals(bookId))
            .findFirst()
            .ifPresent(bookLoan -> {
                user.getRentedBooks().remove(bookLoan);
                logger.info("Book returned by " + user.getName());
            });

    }
}
