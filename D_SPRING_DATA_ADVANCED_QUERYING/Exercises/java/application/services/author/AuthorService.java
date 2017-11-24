package application.services.author;

import application.models.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    void save(Author author);

    void getAuthorByEndString(String end);
}
