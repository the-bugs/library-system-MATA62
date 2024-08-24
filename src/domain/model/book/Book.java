package domain.model.book;

import java.util.List;

public record Book(
        Integer id,
        String title,
        String publisher,
        List<Author> authors,
        Integer edition,
        Integer yearPublication) {
}
