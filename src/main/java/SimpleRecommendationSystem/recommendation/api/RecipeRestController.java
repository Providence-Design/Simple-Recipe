package SimpleRecommendationSystem.recommendation.api;

import SimpleRecommendationSystem.recommendation.model.Recipe;
import SimpleRecommendationSystem.recommendation.services.RecipeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeRestController {

    private final RecipeServiceImpl recipeServiceImpl;

    public RecipeRestController(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @GetMapping
    public List<Recipe> getRecipe(@RequestParam(required = false) String name, @RequestParam(required = false) String ingredient, @RequestParam(required = false) String instruction) {
        return recipeServiceImpl.getRecipes(name, ingredient, instruction);
    }

}
