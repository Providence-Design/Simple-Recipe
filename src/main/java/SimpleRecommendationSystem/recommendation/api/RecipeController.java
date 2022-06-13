package SimpleRecommendationSystem.recommendation.api;

import SimpleRecommendationSystem.recommendation.model.Recipe;
import SimpleRecommendationSystem.recommendation.services.Ingredient;
import SimpleRecommendationSystem.recommendation.services.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping()
    public List<Recipe> getRecipe(@RequestParam (required = false) String name, @RequestParam (required = false) String ingredient, @RequestParam (required = false) String instruction) {
        System.out.println("my recipe name:" + name);
        if(name != null){
            return  recipeRepository.getByNameV2(name);
        }
        else if(ingredient != null){
            System.out.println("My recipe name given the ingredient " + " " +  ingredient);
            return recipeRepository.getByIngredient(ingredient);

        }else if(instruction != null){
            System.out.println("Given instruction name return recipes that have that instruction" + " " + instruction);
            return recipeRepository.getByInstruction(instruction);
        }
        else {
            return recipeRepository.getRecipes();

        }

   }


}
