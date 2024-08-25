package domain.commands;

import domain.common.Params;

public class ExitCommand extends Command {

    @Override
    public void execute(Params params) {
        System.out.println("Exiting...");
        System.exit(0);
    }
}
