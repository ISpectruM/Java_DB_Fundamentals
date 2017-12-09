package app.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "photographers")
public class Photographer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    @NotNull
    private String firstName;

    @Column(name = "last_name",nullable = false)
    @NotNull
    private String lastName;

    @Column(name = "phone")
    @Pattern(regexp = "^\\+([0-9]){1,3}\\/([0-9]{8,10})$",message = "Must match the pattern")
    private String phone;

    @ManyToOne(optional = false,cascade = CascadeType.ALL)
    private BasicCamera primaryCamera;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private BasicCamera secondaryCamera;

    @OneToMany(mappedBy = "owner")
    private List<Accessory> accessories;

    @ManyToMany
    private Set<Workshop> participatesIn;

    @OneToMany
    private Set<Workshop> trainerIn;

    public Photographer() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BasicCamera getPrimaryCamera() {
        return this.primaryCamera;
    }

    public void setPrimaryCamera(BasicCamera primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public BasicCamera getSecondaryCamera() {
        return this.secondaryCamera;
    }

    public void setSecondaryCamera(BasicCamera secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    public List<Accessory> getAccessories() {
        return this.accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public Set<Workshop> getParticipatesIn() {
        return this.participatesIn;
    }

    public void setParticipatesIn(Set<Workshop> participatesIn) {
        this.participatesIn = participatesIn;
    }

    public Set<Workshop> getTrainerIn() {
        return this.trainerIn;
    }

    public void setTrainerIn(Set<Workshop> trainerIn) {
        this.trainerIn = trainerIn;
    }
}
