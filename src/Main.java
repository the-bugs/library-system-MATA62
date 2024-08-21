import domain.commands.CommandInvoker;
import service.InputHandler;

public class Main {
    public static void main(String[] args) {
        CommandInvoker commandInvoker = new CommandInvoker();
        commandInvoker.loadCommands();

        InputHandler inputHandler = new InputHandler(commandInvoker);
        inputHandler.input("  LIV 100");
    }
}