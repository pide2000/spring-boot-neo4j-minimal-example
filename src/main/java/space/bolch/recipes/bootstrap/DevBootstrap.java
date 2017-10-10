package space.bolch.recipes.bootstrap;

 import org.springframework.context.ApplicationListener;
 import org.springframework.context.event.ContextRefreshedEvent;
 import org.springframework.stereotype.Component;
 import space.bolch.recipes.domain.Food;
 import space.bolch.recipes.repositories.FoodRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private FoodRepository foodRepository;

    public DevBootstrap(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        foodRepository.deleteAll();

        Food tomato = new Food("Tomato");
        Food cucumber = new Food("Cucumber");
        foodRepository.save(tomato);
        foodRepository.save(cucumber);

    }
}