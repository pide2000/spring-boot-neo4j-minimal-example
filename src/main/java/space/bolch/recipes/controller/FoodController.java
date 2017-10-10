package space.bolch.recipes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import space.bolch.recipes.repositories.FoodRepository;

@Controller
public class FoodController {
    private FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @RequestMapping("/foods")
    public String getFood(Model model) {

        model.addAttribute("foods", foodRepository.findAll());

        return "foods";
    }



}
