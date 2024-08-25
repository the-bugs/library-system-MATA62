package domain.model.book;

import domain.interfaces.IBook;
import domain.interfaces.IExemplary;

public class Exemplary implements IExemplary {

    private static Integer generatedId = 1;

    private final Integer exemplaryId = generatedId++;
    private final IBook bookLoan;
    private final Boolean isAvailable;

    public Exemplary(final IBook bookLoan) {
        this.bookLoan = bookLoan;
        this.isAvailable = true;
    }

    @Override
    public Integer getBookCode() {
        return this.bookLoan.getId();
    }

    @Override
    public Integer getExemplaryCode() {
        return this.exemplaryId;
    }

    @Override
    public Boolean getStatus() {
        return this.isAvailable;
    }

    @Override
    public IBook getBook() {
        return this.bookLoan;
    }
}
