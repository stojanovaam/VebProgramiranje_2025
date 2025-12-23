package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "chefs")
@Entity
public class Chef {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String bio;

    @OneToMany(mappedBy="chef")
    private List<Dish> dishes=new ArrayList<>();

    private Gender gender;

    public enum Gender{
        NOTDEFINED, WOMAN, MAN
    }

    public Chef(String firstName, String lastName, String bio, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.gender = gender;
    }
}
