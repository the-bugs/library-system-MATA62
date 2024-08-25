package domain.commands;


import domain.common.Params;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static domain.common.Constants.*;

public class CommandInvoker {

    private final Logger logger = Logger.getLogger(getClass().getName());

    private final Map<String, Command> commands = new HashMap<>();

    public void loadCommands() {
        commands.put(EXIT, new ExitCommand());
        commands.put(BOOK_LOAN, new LoanBookCommand());
        commands.put(BOOK_RETURN, new ReturnBookCommand());
        commands.put(BOOK_SEARCH, new SearchBookCommand());
        commands.put(BOOK_RESERVATION, new ReservationBookCommand());
        commands.put(REGISTER_OBSERVER, new RegisterObserverCommand());
        commands.put(QUANTITY_NOTIFICATION, new ShowNotificationCommand());
    }

    public void execute(String commandName, Params params) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute(params);
        } else {
            logger.log(
                    Level.INFO,
                    "Command not found."
            );
        }
    }
}
