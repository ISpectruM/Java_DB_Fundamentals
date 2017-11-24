package application.repositories;

import application.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,BigInteger> {

    List<Author> findAllByFirstNameEndsWith(String end);

}
