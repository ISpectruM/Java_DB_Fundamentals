package application.services.author;

import application.models.Author;
import application.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorRepository getAuthorRepository() {
        return this.authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public void save(Author author){
        this.authorRepository.save(author);
    }

    @Override
    public void getAuthorByEndString(String end){
        List<Author> result = this.authorRepository.findAllByFirstNameEndsWith(end);
        for (Author author : result) {
            System.out.println(author.getFirstName() +" "+ author.getLastName());
        }
    }


}
