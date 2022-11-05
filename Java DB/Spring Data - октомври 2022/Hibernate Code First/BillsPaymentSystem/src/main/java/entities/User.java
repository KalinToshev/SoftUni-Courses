package entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(
            name = "users_billing_details",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "billing_detail_id", referencedColumnName = "id")
    )
    private Set<BillingDetail> billingDetails;

    public User() {

        this.billingDetails = new HashSet<>();

    }

    public User(String firstName, String lastName, String email, String password) {

        this.firstName = firstName;

        this.lastName = lastName;

        this.email = email;

        this.password = password;

        this.billingDetails = new HashSet<>();

    }

    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }

    public String getFirstName() {

        return firstName;

    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;

    }

    public String getLastName() {

        return lastName;

    }

    public void setLastName(String lastName) {

        this.lastName = lastName;

    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    public String getPassword() {

        return password;

    }

    public void setPassword(String password) {

        this.password = password;

    }

    public Set<BillingDetail> getBillingDetails() {

        return Collections.unmodifiableSet(billingDetails);

    }

    public void setBillingDetails(Set<BillingDetail> billingDetails) {

        this.billingDetails = billingDetails;

    }

    public void addBillingDetail(BillingDetail billingDetail) {

        this.billingDetails.add(billingDetail);

    }

    public void removeBillingDetail(BillingDetail billingDetail) {

        this.billingDetails.remove(billingDetail);

    }

}
