package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Chef {
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;
    private List<Dish> dishes;
    private Gender gender;

    public enum Gender{
        NOTDEFINED, WOMAN, MAN
    }

    public Chef(String firstName, String lastName, String bio, Gender gender) {
        this.id=(long) (Math.random() * 1000);
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.dishes = dishes;
        this.gender = gender;
    }
}
