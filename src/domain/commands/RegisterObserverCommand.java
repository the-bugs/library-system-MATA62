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

        if(user == null || book == null) {
            logger.info("User or book not found");
            return;
        }
        if (!user.canBeObserver()) {
            logger.info("User is not eligible to be an observer.");
            return;
        }

        if(user.canBeObserver()){
            book.attachObserver((IObserver) user);
            logger.info("User " + user.getName() +
                    " is now observing book " + book.getTitle());
        }
    }
}
