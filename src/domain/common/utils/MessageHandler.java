package domain.common.utils;

public abstract class MessageHandler {


    public static void enterCommandMessage() {
        System.out.println("Enter command: ");
    }

    public static void invalidInputMessage() {
        System.out.println("Invalid input. Try again.");
    }

    public static void errorReadingInputMessage() {
        System.out.println("Error reading input");
    }

}
