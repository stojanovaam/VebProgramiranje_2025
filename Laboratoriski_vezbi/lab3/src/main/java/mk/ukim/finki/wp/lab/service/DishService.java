package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DishService {
    List<Dish> listDishes(Long chefId);
    Dish findByDishId(String dishId);
    List<Dish> findAllByChefId(Long chefId);
    Dish findById(Long id);
    Dish create(String dishId, String name, String cuisine, int preparationTime, Long chefId);
    Dish update(Long id, String dishId, String name, String cuisine, int preparationTime, Long chefId);
    void delete(Long id);
}
