package entities;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

import java.time.LocalDate;

@Entity(name = "users")
public class User {

    @Id
    private long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "age")
    private int age;

    @Column(name = "registration_date")
    private LocalDate registration;

    public User(String username, int age, LocalDate registration) {
        setUsername(username);
        setAge(age);
        setRegistration(registration);
    }

    public User() {};

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public LocalDate getRegistration() {
        return registration;
    }

    private void setRegistration(LocalDate registration) {
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", registration=" + registration +
                '}';
    }

}
