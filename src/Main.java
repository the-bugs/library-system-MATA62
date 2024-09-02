import domain.commands.CommandInvoker;
import service.InputHandler;

public class Main {
    public static void main(String[] args) {

        final CommandInvoker commandInvoker = new CommandInvoker();
        commandInvoker.loadCommands();

        final InputHandler inputHandler = new InputHandler(commandInvoker);
        inputHandler.start();
//        inputHandler.start("liv 100");
//        inputHandler.start("sai");
//        inputHandler.input("res 123 100");
    }
}