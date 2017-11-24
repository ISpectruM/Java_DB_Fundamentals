package application.services.book;

import application.enums.EditionType;
import application.models.Book;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

public interface BookService {
    void save(Book book);

    void getAllBooksByAgeRestriction(String input);

    void getAllBooksByEditionTypeAndCopiesCount(EditionType type, int count);

    void getAllByPriceBetween(String min, String max);

    void getAllNotInYear(String year);

    void getBooksByDateBefore(String inputDate) throws ParseException;

    void getBooksContainingAString(String str);
}


