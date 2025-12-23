/*
package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryChefRepository implements ChefRepository {
    @Override
    public List<Chef> findAll() {
        return DataHolder.chefs;
    }

    @Override
    public Optional<Chef> findById(Long id) {
        for(Chef najden : DataHolder.chefs){
               if(najden.getId().equals(id)){
                   return Optional.of(najden);
                   //najden go pretvora vo Optional i go vrakja
               }
        }
        return Optional.empty();
    }

    @Override
    public Chef save(Chef chef) {
        Optional<Chef> najden=findById(chef.getId());
        if(najden.isPresent()){
            //znachi najden e takov gotvach
            //azhuriraj go
            Chef azhuriraj=najden.get();
            azhuriraj.setFirstName(chef.getFirstName());
            azhuriraj.setLastName(chef.getLastName());
            azhuriraj.setBio(chef.getBio());
            azhuriraj.setGender(chef.getGender());
            return azhuriraj;
        }
        //AKO NE POSTOI DODAJ NOV
        DataHolder.chefs.add(chef);
        return chef;
    }

    @Override
    public void deleteById(Long id) {
        for(Chef deletedChef:DataHolder.chefs){
            if(deletedChef.getId().equals(id)){
                DataHolder.chefs.remove(deletedChef);
                break;
            }
        }
    }
}
*/
