package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Chef> chefs=new ArrayList<>();
    public static List<Dish> dishes=new ArrayList<>();

    @PostConstruct
    public void initializeValues(){

        for(int i=0;i<5;i++) {
            Dish newDish = new Dish(Integer.toString(i),
                    "DishName"+i,
                    "Cuisine"+i,
                    i);
            dishes.add(newDish);

            Chef newChef=new Chef((long) i,
                    "FirstName"+i,
                    "LastName" +i,
                    "Bio" +i,
                    new ArrayList<>());
            chefs.add(newChef);
        }
    }
}
