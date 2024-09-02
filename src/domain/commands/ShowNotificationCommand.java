package domain.commands;

import domain.common.Params;

public class ShowNotificationCommand extends Command {

    @Override
    public void execute(Params params) {

        final var userId = Integer.parseInt(params.getFirstKey());
        final var user = repository.findUserById(userId);

        if(user == null) {
            logger.info("User not found");
            return;
        }
        if (!user.canBeObserver()) {
            logger.info("User is not an observer.");
            return;
        }

        if(user.canBeObserver()){
            var notifications = user.getNotifications();
            logger.info("User " + user.getName() + " has " + notifications + " notifications");
        }

    }
}
