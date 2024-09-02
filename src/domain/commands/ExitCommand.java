package domain.commands;

import domain.common.Params;

import static domain.common.Constants.EXITING;

public class ExitCommand extends Command {

    @Override
    public void execute(Params params) {
        logger.info(EXITING);
        System.exit(0);
    }
}
