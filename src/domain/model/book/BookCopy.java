package domain.model.book;

public class BookCopy {

    private static Integer generatedId = 1;

    private final Integer bookCopyId = generatedId++;
    private final Integer bookId;
    private Boolean isAvailable;

    public BookCopy(final Book bookLoan) {
        this.bookId = bookLoan.getId();
        this.isAvailable = true;
    }

    public Integer getBookId() {
        return this.bookId;
    }

    public Integer getBookCopyId() {
        return this.bookCopyId;
    }

    public void setStatus(Boolean status) {
        this.isAvailable = status;
    }

    public Boolean getStatus() {
        return this.isAvailable;
    }

}
