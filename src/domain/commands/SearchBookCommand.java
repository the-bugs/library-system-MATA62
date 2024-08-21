package domain.commands;

import domain.common.Params;

public class SearchBookCommand extends Command {


    @Override
    public void execute(Params params) {
        final var book = repository.findBookById(Integer.parseInt(params.getFirstKey()));
        System.out.println(book.toString());
    }
}
