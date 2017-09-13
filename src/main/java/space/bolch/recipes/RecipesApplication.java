package space.bolch.recipes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import space.bolch.recipes.domain.Food;
import space.bolch.recipes.repositories.FoodRepository;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EnableNeo4jRepositories
public class RecipesApplication {

	private final static Logger log = LoggerFactory.getLogger(RecipesApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RecipesApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(FoodRepository foodRepository) {
		return args -> {

			foodRepository.deleteAll();

			Food tomato = new Food("Tomato");

			 log.info("Before linking up with Neo4j...");

			foodRepository.save(tomato);

			log.info("Lookup each person by name...");
			foodRepository.findAll().forEach(food -> log.info(
					"\t" + food.getName().toString()));
		};
	}

}
