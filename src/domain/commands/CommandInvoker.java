package domain.commands;


import domain.common.Params;

import java.util.HashMap;
import java.util.Map;

import static domain.common.Constants.BOOK_SEARCH;

public class CommandInvoker {

    private final Map<String, Command> commands = new HashMap<>();

    public void loadCommands() {
        commands.put(BOOK_SEARCH, new SearchBookCommand());
    }

    public void execute(String commandName, Params params) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute(params);
        } else {
            System.out.println("Command not found: " + commandName);
        }
    }
}
