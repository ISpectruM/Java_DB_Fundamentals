package hospital_db;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visitations")
public class Visitation {
    private Long id;
    private Date visitationDate;
    private String comments;
    private Patient patient;

    public Visitation() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "visitation_date")
    public Date getVisitationDate() {
        return visitationDate;
    }

    public void setVisitationDate(Date date) {
        this.visitationDate = date;
    }

    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    @ManyToOne
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
