package domain.commands;

import domain.common.Params;

import static domain.common.Constants.USER_OR_BOOK_NOT_FOUND;

public class ReturnBookCommand extends Command {

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

        user.returnBook(book);
        logger.info("Book %s was returned by user %s.".formatted(book.getTitle(), user.getName()));

        book.registerReturn(bookId);
        logger.info("Book %s was registered as returned.".formatted(book.getTitle()));
    }
}
