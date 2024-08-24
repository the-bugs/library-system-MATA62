import domain.commands.CommandInvoker;
import service.InputHandler;

public class Main {
    public static void main(String[] args) {

        final CommandInvoker commandInvoker = new CommandInvoker();
        commandInvoker.loadCommands();

        final InputHandler inputHandler = new InputHandler(commandInvoker);
        inputHandler.input("liv 100");
//        inputHandler.input("res 123 100");
    }
}