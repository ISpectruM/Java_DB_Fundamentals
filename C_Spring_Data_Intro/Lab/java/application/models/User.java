package application.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    private Long id;
    private String username;
    private Integer age;
    private List<Account> accounts;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @OneToMany(targetEntity = Account.class, mappedBy = "id",cascade = CascadeType.ALL)
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
