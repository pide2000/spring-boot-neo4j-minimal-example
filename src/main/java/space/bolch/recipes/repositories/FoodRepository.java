package space.bolch.recipes.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import space.bolch.recipes.domain.Food;

import java.util.List;

@Repository
public interface FoodRepository extends GraphRepository<Food> {
    List<Food> findByName(@Param("name") String name);
}
