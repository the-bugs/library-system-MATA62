package service;

import domain.commands.CommandInvoker;
import domain.common.Params;

import java.util.Arrays;

public class InputHandler {

    private final CommandInvoker commandInvoker;

    public InputHandler(final CommandInvoker commandInvoker) {
        this.commandInvoker = commandInvoker;
    }

    public void input(String input) {
        this.handleInput(input.split(" "));
    }

    private void handleInput(String[] input) {

        final var parts = normalizeInput(input);

        final var commandName = parts[0];
        final var firstKey = parts.length > 1 ? parts[1] : null;
        final var secondKey = parts.length > 2 ? parts[2] : null;

        Params params = new Params(commandName, firstKey, secondKey);
        commandInvoker.execute(commandName, params);
    }

    private String[] normalizeInput(String[] input) {
        return Arrays.stream(input)
                .map(String::trim)
                .map(String::toLowerCase)
                .filter(part -> !part.isEmpty())
                .toArray(String[]::new);
    }
}
