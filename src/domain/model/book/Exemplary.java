package domain.model.book;

import domain.interfaces.IBook;
import domain.interfaces.IExemplary;

public class Exemplary implements IExemplary {

    private static Integer generatedId = 1;

    private final Integer exemplaryId = generatedId++;
    private final Integer bookId;
    private Boolean isAvailable;

    public Exemplary(final IBook bookLoan) {
        this.bookId = bookLoan.getId();
        this.isAvailable = true;
    }

    @Override
    public Integer getBookId() {
        return this.bookId;
    }

    @Override
    public Integer getExemplaryId() {
        return this.exemplaryId;
    }

    @Override
    public void setStatus(Boolean status) {
        this.isAvailable = status;
    }

    @Override
    public Boolean getStatus() {
        return this.isAvailable;
    }

}
