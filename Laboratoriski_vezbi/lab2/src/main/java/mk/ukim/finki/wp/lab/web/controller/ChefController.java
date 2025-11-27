
package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
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
public class ChefController {

    private final ChefService chefService;

    @GetMapping("/chefs")
    public String getChefsPage(@RequestParam(required=false) String error, Model model){
        List<Chef> chefs=chefService.listChefs();
        model.addAttribute("chefs",chefs);
        model.addAttribute("error",error);
        return "listChefs";
    }

    //se kreira Chef zatoa e post
    @PostMapping("/chefs/add")
    public String saveChef(@RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam String bio,
                           @RequestParam Chef.Gender gender){
        chefService.create(firstName, lastName, bio, gender);
        return "redirect:/chefs";
    }

    //da se vrati stranicataq za dodavanje
    @GetMapping("chefs/chef-form")
    public String getAddChefPage(Model model){
        model.addAttribute("genders", Chef.Gender.values());
        return "chef-form";
    }

    //da se vrati stranicata za editiranje
    @GetMapping("/chefs/chef-form/{id}")
    public String getEditChefForm(@PathVariable Long id, Model model){
        Chef editedChef=chefService.findById(id);
        if (editedChef == null) {
            return "redirect:/chefs?error=ChefNotFound";
        }
        model.addAttribute("genders",Chef.Gender.values());
        model.addAttribute("chef",editedChef);
        return "chef-form";
    }

    //vekje se editira neshto, znachi post
    @PostMapping("/chefs/edit/{id}")
    public String editDish(@PathVariable Long id,
                           @RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam String bio,
                           @RequestParam Chef.Gender gender){
        chefService.update(id,firstName,lastName,bio,gender);
        return "redirect:/chefs";
    }

    @GetMapping("/chefs/delete/{id}")
    public String deleteDish(@PathVariable Long id){
        chefService.delete(id);
        return "redirect:/chefs";
    }
}
