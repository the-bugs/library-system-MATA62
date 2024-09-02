package domain.commands;

import domain.common.Params;
import domain.interfaces.IObserver;

public class RegisterObserverCommand extends Command {

    @Override
    public void execute(Params params) {

        final var userId = Integer.parseInt(params.getFirstKey());
        final var bookId = Integer.parseInt(params.getSecondKey());

        final var user = repository.findUserById(userId);
        final var book = repository.findBookById(bookId);

        if (book != null && user != null) {
            if (Boolean.FALSE.equals(user.canBeObserver())) {
                logger.info("User %s is not eligible to be an observer.".formatted(user.getName()));
            } else {
                book.attachObserver((IObserver) user);
                logger.info("User %s is now observing book %s.".formatted(user.getName(), book.getTitle()));
            }
        } else {
            logger.info("User or book not found.");
        }
    }
}
