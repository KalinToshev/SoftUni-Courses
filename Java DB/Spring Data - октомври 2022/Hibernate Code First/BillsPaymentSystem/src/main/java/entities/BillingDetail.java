package entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "billing_details")
public class BillingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String number;

    @ManyToMany(mappedBy = "billingDetails")
    private Set<User> users;

    public BillingDetail() {

        this.users = new HashSet<>();

    }

    public BillingDetail(String number) {

        this.number = number;

        this.users = new HashSet<>();

    }

    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }

    public String getNumber() {

        return number;

    }

    public void setNumber(String number) {

        this.number = number;

    }

    public Set<User> getUsers() {

        return Collections.unmodifiableSet(users);

    }

    public void setUsers(Set<User> users) {

        this.users = users;

    }

    public void addUser(User user) {

        this.users.add(user);

    }

    public void removeUser(User user) {

        this.users.remove(user);

    }

}
