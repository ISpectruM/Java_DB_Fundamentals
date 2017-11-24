package application.services.book;

import application.enums.AgeRestriction;
import application.enums.EditionType;
import application.models.Book;
import application.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

@Service
@Primary
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public void getAllBooksByAgeRestriction(String input){
        input = input.toUpperCase();

        List<Book> found =
                this.bookRepository
                        .findAllByAgeRestriction(AgeRestriction.valueOf(input));
        for (Book book : found) {
            System.out.println(book.getTitle());
        }
    }

    @Override
    public void getAllBooksByEditionTypeAndCopiesCount(EditionType type, int count){
        List<Book> result = this.bookRepository.findAllByEditionTypeAndCopiesLessThan(type,count);
        for (Book book : result) {
            System.out.println(book.getTitle());
        }
    }

    @Override
    public void getAllByPriceBetween(String min, String max){
        List<Book> result = this.bookRepository
                .findAllByPriceLessThanOrPriceGreaterThan(new BigDecimal(min),new BigDecimal(max));
        for (Book book : result) {
            System.out.printf("%s - $%.2f%n",book.getTitle(),book.getPrice());
        }
    }

    @Override
    public void getAllNotInYear(String year){
        List<Book> result = this.bookRepository.findAllByDateNot(year);
        for (Book book : result) {
            System.out.println(book.getTitle());
        }
    }

    @Override
    public void getBooksByDateBefore(String inputDate) throws ParseException {
        Date date;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        date = df.parse(inputDate);
        List<Book> result = this.bookRepository.findAllByReleaseDateBefore(date);
        for (Book book : result) {
            System.out.println(book.getTitle());
        }
    }

    @Override
    public void getBooksContainingAString(String str){
        List<Book> result = this.bookRepository.findAllByTitleContains(str.toLowerCase());
        for (Book book : result) {
            System.out.println(book.getTitle());
        }
    }

    public void getBooksByLastAuthorNameStartingWith(String str){
        List<Book> result = this.bookRepository.findBooksByAuthorLastNameStartsWith(str);
        for (Book book : result) {
            System.out.printf("%s (%s %s)%n",
                    book.getTitle(),
                    book.getAuthor().getFirstName(),
                    book.getAuthor().getLastName());
        }
    }
}
