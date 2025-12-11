package mk.ukim.finki.wp.lab.service.impl;


import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import mk.ukim.finki.wp.lab.service.ChefService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChefServiceImpl implements ChefService {

    private final ChefRepository chef_repo;
    private final DishRepository dish_repo;

    @Override
    public List<Chef> listChefs() {
        return chef_repo.findAll();
    }

    @Override
    public Chef findById(Long id) {
        Optional<Chef> chefOptional=chef_repo.findById(id);
        if(chefOptional.isPresent()){
            return chefOptional.get();
        }
        return null;
    }

    @Override
    public Chef addDishToChef(Long chefId, String dishId) {
        //dish Id
        //chef Id
        //najdi go jadenjeto spored dish Id
        //potoa doddai go vo lisata na chef

        Dish izbranDish=dish_repo.findById(Long.valueOf(dishId)).get();
        Chef izbranChef=findById(chefId);
        izbranChef.getDishes().add(izbranDish);
        return chef_repo.save(izbranChef); //za da se apdejtira vo listata
    }

    @Override
    public Chef create(String firstName, String lastName, String bio, Chef.Gender gender) {
        Chef newChef=new Chef(firstName,lastName,bio,gender);
        chef_repo.save(newChef); //ako objektot vekje postoi se azhurira, ako ne postoi se zachuvuva kako nov, spored chefRepository
        return newChef;
    }

    @Override
    public Chef update(Long id, String firstName, String lastName, String bio, Chef.Gender gender) {
        Chef updatedChef=new Chef(firstName,lastName,bio,gender);
        updatedChef.setId(id);
        chef_repo.save(updatedChef);
        return updatedChef;
    }

    @Override
    public void delete(Long id) {
        chef_repo.deleteById(id);
    }
}
