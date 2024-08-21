package domain.commands;

import domain.common.Params;
import repository.LibraryRepository;

public abstract class Command {

    protected LibraryRepository repository = LibraryRepository.getInstance();

    public abstract void execute(final Params params);
}
