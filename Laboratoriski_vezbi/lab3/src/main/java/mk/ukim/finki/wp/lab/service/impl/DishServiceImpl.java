package mk.ukim.finki.wp.lab.service.impl;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final DishRepository dish_repo;
    private final ChefService chef_service;

    @Override
    public List<Dish> listDishes(Long chefId) {
        if(chefId==null){
            return dish_repo.findAll();
        }else{
            return dish_repo.findAllByChef_Id(chefId);
        }
    }

    @Override
    public Dish findByDishId(String dishId) {
        return dish_repo.findByDishId(dishId).get();
    }

    @Override
    public List<Dish> findAllByChefId(Long chefId) {
        return dish_repo.findAllByChef_Id(chefId);
    }

    @Override
    public Dish findById(Long id) {
        //return dish_repo.findById(id).get(); //go zima dish spored id i go vrakja
        return dish_repo.findById(id).orElse(null);
    }

    @Override
    public Dish create(String dishId, String name, String cuisine, int preparationTime, Long chefId) {
        Chef chef=chef_service.findById(chefId);
        Dish dish=new Dish(dishId,name,cuisine,preparationTime,chef);
        dish_repo.save(dish);   //ako objektot vekje postoi se azhurira, ako ne postoi se zachuvuva kako nov
        return dish;
    }

    @Override
    public Dish update(Long id, String dishId, String name, String cuisine, int preparationTime, Long chefId) {
        Dish dish = findById(id);//mora da mu se setira istoto id spored koe treba da e azhuriran
        Chef chef=chef_service.findById(chefId);
        dish.setDishId(dishId);
        dish.setName(name);
        dish.setCuisine(cuisine);
        dish.setPreparationTime(preparationTime);
        dish.setChef(chef);
        dish_repo.save(dish);
        return dish;
    }

    @Override
    public void delete(Long id) {
        dish_repo.deleteById(id);
    }


}
