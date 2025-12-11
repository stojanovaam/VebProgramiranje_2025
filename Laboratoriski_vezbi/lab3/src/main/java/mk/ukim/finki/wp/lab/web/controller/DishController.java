package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.model.DishRank;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;
    private final ChefService chefService;

    @GetMapping("/dishes")
    public String getDishesPage(@RequestParam(required = false) String error,
                                @RequestParam(required = false) Long chefId,
                                Model model){
        List<Dish> dishes = dishService.listDishes(chefId);
        model.addAttribute("dishes",dishes);
        model.addAttribute("chefs",chefService.listChefs());
        return "listDishes";
    }

    //se kreira dish zatoa e post
    @PostMapping("/dishes/add")
    public String saveDish(@RequestParam String dishId,
                           @RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime,
                           @RequestParam Long chefId,
                           @RequestParam String rank,
                           @RequestParam Double rating){
        DishRank dishRank = DishRank.valueOf(rank);
        dishService.create(dishId,name,cuisine,preparationTime,chefId,dishRank,rating);
        return "redirect:/dishes";
    }

    //da se vrati stranicata za dodavanje
    @GetMapping("/dishes/dish-form")
    public String getAddDishPage(Model model){
        model.addAttribute("chefs",chefService.listChefs());
        return "dish-form";
    }

    //da se vrati stranicata za editiranje
    @GetMapping("/dishes/dish-form/{id}")
    public String getEditDishForm(@PathVariable Long id, Model model){
        Dish dish=dishService.findById(id);
        if (dish == null) {
            return "redirect:/dishes?error=DishNotFound";
        }
        model.addAttribute("dish",dish);
        model.addAttribute("chefs",chefService.listChefs());
        return "dish-form";
    }

    //vekje se editira neshto, znachi post
    @PostMapping("/dishes/edit/{id}")
    public String editDish(@PathVariable Long id,
                           @RequestParam String dishId,
                           @RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime,
                           @RequestParam Long chefId,
                           @RequestParam String rank,
                           @RequestParam Double rating){
        DishRank dishRank = DishRank.valueOf(rank);
        dishService.update(id,dishId,name,cuisine,preparationTime,chefId,dishRank,rating);
        return "redirect:/dishes";
    }

    @PostMapping("/dishes/delete/{id}")
    public String deleteDish(@PathVariable Long id){
        dishService.delete(id);
        return "redirect:/dishes";
    }

    @PostMapping("/chefDetails")
    public String addDishToChef(@RequestParam Long chefId,
                                @RequestParam String dishId,
                                Model model){
        Chef chef=chefService.addDishToChef(chefId,dishId);
        model.addAttribute("chef",chef);
        return "chefDetails";
    }   
    
}
