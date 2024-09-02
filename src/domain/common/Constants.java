package domain.common;

public abstract class Constants {

    private Constants() {
    }

    // Commands
    public static final String EXIT = "sai";
    public static final String BOOK_LOAN = "emp"; // Empréstimo de livro
    public static final String BOOK_RETURN = "dev"; // Devolução de livro
    public static final String BOOK_SEARCH = "liv"; // Consulta de livro
    public static final String BOOK_RESERVATION = "res"; // Reserva de livro
    public static final String REGISTER_OBSERVER = "obs"; // Cadastrar professor como observador
    public static final String QUANTITY_NOTIFICATION = "ntf"; // Quantidade de notificações que um professor recebeu

    // Messages

    public static final String EXITING = "Exiting...";
    public static final String COMMAND_NOT_FOUND = "Command not found.";

    public static final Integer PROFESSOR_LOAN_DAYS = 7;
    public static final Integer GRADUATE_STUDENT_LOAN_DAYS = 5;
    public static final Integer POSTGRADUATE_STUDENT_LOAN_DAYS = 3;

    public static final Integer QUANTITY_BOOKS_PROFESSOR = -1; // -1 significa que o professor pode pegar quantos livros quiser
    public static final Integer QUANTITY_BOOKS_GRADUATE_STUDENT = 3;
    public static final Integer QUANTITY_BOOKS_POSTGRADUATE_STUDENT = 4;

    public static final String TOTAL_OF = "Total of %s: %d";
    public static final String REPOSITORY_ADDRESS = "LibraryRepository address: %s";

    public static final String USER_OR_BOOK_NOT_FOUND = "User or book not found.";
    public static final String USER_IS_NOT_ELIGIBLE_TO_RENT_BOOK = "User %s is not eligible to rent a book. Cause: %s";
    public static final String USER_HAS_OVERDUE_BOOKS = "User %s has overdue books";
    public static final String USER_REACHED_MAXIMUM_BOOKS_ALLOWED =
            "User %s is not eligible. Cause: has reached the maximum (%d) number of books allowed";
    public static final String REMOVE_BOOK_RESERVATION_FROM = "Reservation for book with id %d was removed from user %s.";

    public static final String BOOK_NOT_FOUND = "Book not found.";
    public static final String BOOK_WAS_RENTED_BY = "%s was rented by user %s.";
    public static final String BOOK_WAS_RESERVED_BY = "%s was reserved by user %s.";
    public static final String NO_AVAILABLE_COPIES_OF_BOOK = "No available copies of book %s.";
}
