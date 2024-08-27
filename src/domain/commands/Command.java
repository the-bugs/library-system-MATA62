package domain.commands;

import domain.common.Params;
import repository.LibraryRepository;

import java.util.logging.Logger;

public abstract class Command {

    protected Logger logger = Logger.getLogger(getClass().getName());

    protected LibraryRepository repository = LibraryRepository.getInstance();

    public abstract void execute(final Params params);
}
