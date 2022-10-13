package pl.hyorinmaru.mechanic.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 25)
    @Length(min = 5, message = "Length has to be at least 5 characters")
    @Length(max = 25, message = "Length has have max of 25 characters")
    private String username;

    private String password;

    private int active;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToOne(fetch = FetchType.EAGER)
    private UserData userData;

    @OneToMany(mappedBy = "owner")
    private List<Car> cars;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                "email" + userData.getEmail() + '\'' +
                '}';
    }
}
