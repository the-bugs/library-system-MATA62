package domain.commands;

import domain.common.Params;

import static domain.common.Constants.BOOK_NOT_FOUND;

public class SearchBookCommand extends Command {

    @Override
    public void execute(Params params) {
        final var book = repository.findBookById(Integer.parseInt(params.getFirstKey()));

        if (book == null) {
            logger.info(BOOK_NOT_FOUND);
        } else {
            logger.info(book.toString());
        }

    }
}
