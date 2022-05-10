package SimpleRecommendationSystem.recommendation.api;

import SimpleRecommendationSystem.recommendation.model.Recipe;
import SimpleRecommendationSystem.recommendation.services.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recipe")
public class RecipeController {

    private RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping()
    public List<Recipe> getRecipe(@RequestParam String recipe) {
        System.out.println("my recipe name:" + recipe);
        // "http://localhost:8080/recipe?recipe=jo llof"
        // TODO: // recipeRepository.getByName(recipe);
        return recipeRepository.getRecipes();
    }

}
