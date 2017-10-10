package space.bolch.recipes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableNeo4jRepositories
@EnableTransactionManagement
@EnableWebMvc
public class RecipesApplication {

	private final static Logger log = LoggerFactory.getLogger(RecipesApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RecipesApplication.class, args);
	}

}
