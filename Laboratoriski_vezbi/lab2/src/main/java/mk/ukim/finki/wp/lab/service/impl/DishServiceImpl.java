package mk.ukim.finki.wp.lab.service.impl;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final DishRepository dish_repo;

    @Override
    public List<Dish> listDishes() {
        return dish_repo.findAll();
    }

    @Override
    public Dish findByDishId(String dishId) {
        return dish_repo.findByDishId(dishId);
    }

    @Override
    public Dish findById(Long id) {
        //return dish_repo.findById(id).get(); //go zima dish spored id i go vrakja
        return dish_repo.findById(id).orElse(null);
    }

    @Override
    public Dish create(String dishId, String name, String cuisine, int preparationTime) {
        Dish dish=new Dish(dishId,name,cuisine,preparationTime);
        dish_repo.save(dish);   //ako objektot vekje postoi se azhurira, ako ne postoi se zachuvuva kako nov
        return dish;
    }

    @Override
    public Dish update(Long id, String dishId, String name, String cuisine, int preparationTime) {
        Dish updatedDish=new Dish(dishId,name,cuisine,preparationTime);
        updatedDish.setId(id);     //mora da mu se setira istoto id spored koe treba da e azhuriran
        dish_repo.save(updatedDish);
        return updatedDish;
    }

    @Override
    public void delete(Long id) {
        dish_repo.deleteById(id);
    }


}
