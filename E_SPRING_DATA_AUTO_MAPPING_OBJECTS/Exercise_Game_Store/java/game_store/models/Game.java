package game_store.models;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game {
    private Long id;
    private String title;
    private BigDecimal price;
    private BigDecimal size;
    private String trailer;
    private String thumbnailUrl;
    private String description;
    private Date releaseDate;
    private Set<Order> orders;

    public Game() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title")
    @Size(min = 3,max = 100)
    @Pattern(regexp = "^([A-Z].*)")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Digits(integer = 6, fraction = 2)
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Price must be a positive number");
        }
        this.price = price;
    }

    @Digits(integer = 5, fraction = 1)
    public BigDecimal getSize() {
        return this.size;
    }

    public void setSize(BigDecimal size) {
        if (size.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Size must be positive number!");
        }
        this.size = size;
    }

    @Column(name = "trailer")
    @Size(min = 11,max = 11)
    public String getTrailer() {
        return this.trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Column(name = "thumbnail_url")
    @Pattern(regexp = "^(http:\\/\\/|https:\\/\\/)+[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$")
    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Column(name = "description")
    @Size(min = 20)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "release_date")
    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @ManyToMany(mappedBy = "products")
    public Set<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }


}
