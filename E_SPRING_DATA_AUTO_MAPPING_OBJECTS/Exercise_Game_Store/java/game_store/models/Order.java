package game_store.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    private Long id;
    private User buyer;
    private Collection<Game> products;

    public Order() {
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

    @ManyToOne(targetEntity = User.class)
    public User getBuyer() {
        return this.buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    @ManyToMany
    @JoinTable(name = "orders_products",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "game_id"))
    public Collection<Game> getProducts() {
        return this.products;
    }

    public void setProducts(Collection<Game> products) {
        this.products = products;
    }
}
