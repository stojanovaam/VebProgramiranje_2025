package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataHolder {
    //public static List<Chef> chefs=new ArrayList<>();
    //public static List<Dish> dishes=new ArrayList<>();
    private final ChefRepository chefRepository;
    private final DishRepository dishRepository;

    @PostConstruct
    public void initializeValues(){

        for(int i=0;i<5;i++) {
            Chef newChef=new Chef(
                    "FirstName"+i,
                    "LastName" +i,
                    "Bio" +i,
                    Chef.Gender.NOTDEFINED);
            chefRepository.save(newChef);

            Dish newDish = new Dish(Integer.toString(i),
                    "DishName"+i,
                    "Cuisine"+i,
                    i,
                    newChef);
            dishRepository.save(newDish);
        }
    }
}
