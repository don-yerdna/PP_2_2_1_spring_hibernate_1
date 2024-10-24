package hiber.model;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;
@Component
@Scope("prototype")
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "user")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Car getCar() {
        return car;
    }

    @Autowired
    public void setCar(Car car) {
        this.car = car;
        car.setUser(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(car, user.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, car);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User{id=").append(id)
                .append(", firstName='").append(firstName)
                .append(", lastName='").append(lastName)
                .append(", email='").append(email);
        if (car != null) {
            builder.append(", car=").append(car.toString());
        }
        builder.append("}");
        return builder.toString();
    }
}
