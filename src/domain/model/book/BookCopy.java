package domain.model.book;

/**
 * Esta classe representa um Exemplar
**/
public class BookCopy {

    private static Integer generatedId = 1;

    private final Integer copyId = generatedId++;
    private final BookLoan bookLoan;

    public BookCopy(final BookLoan bookLoan) {
        this.bookLoan = bookLoan;
    }
}
