package app.entities;

import app.entities.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "addresses")
public class Address {
    private Long id;
    private String city;
    private String country;
    private Set<Employee> employees;

    public Address() {
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

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    @OneToMany(targetEntity = Employee.class,mappedBy = "address")
    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employes) {
        this.employees = employes;
    }
}
