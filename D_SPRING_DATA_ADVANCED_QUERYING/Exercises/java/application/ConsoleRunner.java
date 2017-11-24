package application;

import application.enums.AgeRestriction;
import application.enums.EditionType;
import application.models.Author;
import application.models.Book;
import application.models.Category;
import application.repositories.BookRepository;
import application.services.author.AuthorServiceImpl;
import application.services.book.BookServiceImpl;
import application.services.category.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {
    private AuthorServiceImpl authorService;
    private BookServiceImpl bookService;
    private CategoryServiceImpl categoryService;

    @Autowired
    public ConsoleRunner(AuthorServiceImpl authorService, BookServiceImpl bookService, CategoryServiceImpl categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
//        seedDatabase();
//        ---1.	Books Titles by Age Restriction
//        this.bookService.getAllBooksByAgeRestriction("minor");

//        ---2.	Golden Books
//        this.bookService.getAllBooksByEditionTypeAndCopiesCount(EditionType.GOLD,5000);

//        ---3.	Books by Price
//        this.bookService.getAllByPriceBetween("5", "40");

//        ---4.	Not Released Books
//        this.bookService.getAllNotInYear("2000");

//        ---5.	Books Released Before Date
//        this.bookService.getBooksByDateBefore("30-12-1989");
//
//        ---6.	Authors Search
//        this.authorService.getAuthorByEndString("e");

//        ---7.	Books Search
//        this.bookService.getBooksContainingAString("WOR ");
//
//        ---8.	Book Titles Search
//        this.bookService.getBooksByLastAuthorNameStartingWith("gr");


    }

    public void seedDatabase() throws IOException, ParseException {
        this.seedAuthors();
        this.seedCategories();
        this.seedBooks();
    }

    public void seedAuthors() throws IOException {
        String filePath = "./src/main/resources/files/authors.txt";

        BufferedReader authorReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = authorReader.readLine()) != null){
            String[] names = line.trim().split(" ");
            Author author = new Author();
            author.setFirstName(names[0].trim());
            author.setLastName(names[1].trim());
            this.authorService.save(author);
        }

    }

    public void seedCategories() throws IOException {
        String filePath = "./src/main/resources/files/categories.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null){
            Category category = new Category();
            if (!line.isEmpty()){
                category.setName(line.trim());
                this.categoryService.save(category);
            }
        }
    }

    public void seedBooks() throws IOException, ParseException {
        String path = "./src/main/resources/files/books.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        Random random = new Random();
        List<Author> authors = this.authorService.findAll();

        String line = reader.readLine();
        while ((line = reader.readLine()) != null){
            String[] tokens = line.split("\\s+");

            int randomIndex = random.nextInt(authors.size());
            Author currAuthor = authors.get(randomIndex);
            int editionIndex = Integer.decode(tokens[0].trim());
            EditionType currEdition =
                    EditionType.values()[editionIndex];

            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(tokens[1]);

            int copies = Integer.parseInt(tokens[2]);

            BigDecimal price = new BigDecimal(tokens[3]);

            AgeRestriction ageRestriction =
                    AgeRestriction.values()[Integer.decode(tokens[4])];

            StringBuilder title = new StringBuilder();

            Arrays.stream(tokens)
                    .skip(5)
                    .forEach(w -> title.append(w).append(" "));
            title.delete(title.lastIndexOf(" "), title.lastIndexOf(" "));

            Book book = new Book();
            book.setEditionType(currEdition);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title.toString());
            book.setAuthor(currAuthor);

            Set<Category> bookCategories = new HashSet<>();
            List<Category> categories = this.categoryService.findAll();
            for (int i = 0; i < categories.size(); i++) {
                int randomCategory = random.nextInt(categories.size());
                Category currCategory = categories.get(randomCategory);
                if (!bookCategories.contains(currCategory)){
                    bookCategories.add(currCategory);
                }
            }
            book.setCategories(bookCategories);
            this.bookService.save(book);
        }
    }
}
