package domain.common;

public abstract class Constants {

    private Constants() {
    }

    public static final String EXIT = "sai";

    public static final String BOOK_LOAN = "emp"; // Empréstimo de livro
    public static final String BOOK_RETURN = "dev"; // Devolução de livro
    public static final String BOOK_SEARCH = "liv"; // Consulta de livro
    public static final String BOOK_RESERVATION = "res"; // Reserva de livro

    public static final String REGISTER_OBSERVER = "obs"; // Cadastrar professor como observador
    public static final String QUANTITY_NOTIFICATION = "ntf"; // Quantidade de notificações que um professor recebeu

    public static final Integer PROFESSOR_LOAN_DAYS = 7;
    public static final Integer GRADUATE_STUDENT_LOAN_DAYS = 5;
    public static final Integer POSTGRADUATE_STUDENT_LOAN_DAYS = 3;

    public static final Integer QUANTITY_BOOKS_PROFESSOR = -1; // -1 significa que o professor pode pegar quantos livros quiser
    public static final Integer QUANTITY_BOOKS_GRADUATE_STUDENT = 3;
    public static final Integer QUANTITY_BOOKS_POSTGRADUATE_STUDENT = 4;

}
