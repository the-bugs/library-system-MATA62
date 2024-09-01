package service;

import domain.commands.CommandInvoker;
import domain.common.Params;
import domain.common.utils.MessageHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InputHandler {

    private final BufferedReader scanner;
    private final CommandInvoker commandInvoker;

    public InputHandler(final CommandInvoker commandInvoker) {
        this.commandInvoker = commandInvoker;
        this.scanner = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() {
        // TODO: Melhorar loop.
        while (true) {
            MessageHandler.enterCommandMessage();
            try {
                final String userInput = scanner.readLine();
                this.splitInput(userInput);
            } catch (IOException e) {
                MessageHandler.errorReadingInputMessage();
            }
        }
    }

    private void splitInput(String input) {
        this.handleInput(input.split(" "));
    }

    private void handleInput(String[] input) {

        final var parts = normalizeInput(input);

        final var commandName = parts[0];
        final var firstKey = parts.length > 1 ? parts[1] : null;
        final var secondKey = parts.length > 2 ? parts[2] : null;

        if (firstKey == null) {
            MessageHandler.invalidInputMessage();
            return;
        }

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
