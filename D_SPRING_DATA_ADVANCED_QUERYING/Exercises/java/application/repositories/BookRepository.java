package application.repositories;

import application.enums.AgeRestriction;
import application.enums.EditionType;
import application.models.Author;
import application.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal price, BigDecimal price2);

    @Query("SELECT b FROM Book b WHERE SUBSTRING(b.releaseDate,1,4) NOT LIKE :year")
    List<Book> findAllByDateNot(@Param("year") String year);

    List<Book> findAllByReleaseDateBefore(Date releaseDate);

    List<Book> findAllByTitleContains(String str);

    List<Book> findBooksByAuthorLastNameStartsWith(String str);

}
