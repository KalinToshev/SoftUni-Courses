package entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "medicaments")
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "medicaments")
    private Set<Visitation> visitations;

    @ManyToMany(mappedBy = "medicaments")
    private Set<Patient> patients;

    public Medicament() {
        this.visitations = new HashSet<>();
        this.patients = new HashSet<>();
    }

    public Medicament(String name) {
        this.name = name;
        this.visitations = new HashSet<>();
        this.patients = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Visitation> getVisitations() {
        return Collections.unmodifiableSet(visitations);
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    public void addVisitation(Visitation visitation) {
        this.visitations.add(visitation);
    }

    public void removeVisitation(Visitation visitation) {
        this.visitations.remove(visitation);
    }

    public Set<Patient> getPatients() {
        return Collections.unmodifiableSet(patients);
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public void removePatient(Patient patient) {
        this.patients.remove(patient);
    }

}
