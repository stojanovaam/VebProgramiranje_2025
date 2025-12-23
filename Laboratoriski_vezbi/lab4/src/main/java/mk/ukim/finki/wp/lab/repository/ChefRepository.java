package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Long>{
    //Optional<Dish> findByChefId(String id);
    /*List<Chef> findAll();
    Optional<Chef> findById(Long id);
    Chef save(Chef chef);
    void deleteById(Long id);*/
}
