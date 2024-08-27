package domain.interfaces;

import domain.model.book.Author;

import java.util.List;

public interface IBook {

    Integer getId();

    String getTitle();

    String getPublisher();

    List<Author> getAuthors();

    Integer getEdition();

    Integer getYearPublication();
  
    List<IReservation> getReservations();

    void addExemplary(IExemplary exemplary);

    List<IExemplary> getExemplaries();

}
