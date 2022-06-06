package SimpleRecommendationSystem.recommendation.api;

import SimpleRecommendationSystem.recommendation.model.Recipe;
import SimpleRecommendationSystem.recommendation.services.Ingredient;
import SimpleRecommendationSystem.recommendation.services.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping()
    public List<Recipe> getRecipe(@RequestParam (required = false) String name, @RequestParam (required = false) String ingredient) {
        System.out.println("my recipe name:" + name);
        if(name != null){
            return  recipeRepository.getByNameV2(name);
        }
        else if(ingredient != null){
            System.out.println("My recipe name given the ingredient " + " " +  ingredient);

            return recipeRepository.getByIngredient(ingredient);
        }
        else {
            return recipeRepository.getRecipes();

        }

   }


}
