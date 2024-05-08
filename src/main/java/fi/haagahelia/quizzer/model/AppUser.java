package fi.haagahelia.quizzer.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false, updatable = false)
    private Long userId;

    // Username with unique constraint
    @Column(name = "userName", nullable = false, unique = true)
    private String userName;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Quiz> quizzes;


    public AppUser(String userName, String role, String firstName, String lastName) {
        super();
        this.userName = userName;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public AppUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", role=" + role + ", firstName=" + firstName
                + ", lastName=" + lastName + ", quizzes=" + quizzes + "]";
    }

}
