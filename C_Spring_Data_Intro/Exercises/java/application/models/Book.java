package application.models;

import application.enums.AgeRestriction;
import application.enums.EditionType;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    private int book_id;
    private String title;
    private String description;
    private EditionType edition_type;
    private BigDecimal price;
    private int copies;
    private Date release_date;
    private AgeRestriction age_restriction;
    private Author author;
    private Set<Category> categories;

    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getBook_id() {
        return this.book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Column(nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "edition_type",nullable = false)
    public EditionType getEdition_type() {
        return edition_type;
    }

    public void setEdition_type(EditionType edition_type) {
        this.edition_type = edition_type;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(nullable = false)
    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    @Column(name="age_restriction", nullable = false)
    public AgeRestriction getAge_restriction() {
        return this.age_restriction;
    }

    public void setAge_restriction(AgeRestriction age_restriction) {
        this.age_restriction = age_restriction;
    }

    @ManyToOne(targetEntity = Author.class)
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToMany
    @JoinTable(name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id",referencedColumnName = "category_id"))
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
