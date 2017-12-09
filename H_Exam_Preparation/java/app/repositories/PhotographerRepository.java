package app.repositories;

import app.model.entities.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer,Long>{
    Photographer findByFirstNameAndLastName(String firstName, String lastName);
}
