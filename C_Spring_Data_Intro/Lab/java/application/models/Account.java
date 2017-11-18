package application.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Account {
    private Long id;
    private BigDecimal balance;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        if (BigDecimal.valueOf(0).compareTo(balance) > 0){
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }

    @ManyToOne(targetEntity = User.class, optional = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
