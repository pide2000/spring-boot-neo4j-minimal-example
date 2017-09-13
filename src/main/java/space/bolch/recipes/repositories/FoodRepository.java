package space.bolch.recipes.repositories;


import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import space.bolch.recipes.domain.Food;

@Repository
public interface FoodRepository extends GraphRepository<Food> {
}
