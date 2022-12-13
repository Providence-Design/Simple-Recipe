package SimpleRecommendationSystem.recommendation.services;

import SimpleRecommendationSystem.recommendation.model.Recipe;
import SimpleRecommendationSystem.recommendation.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getRecipes(String name, String ingredient, String instruction) {
        System.out.println("my recipe name:" + name);
        if (name != null) {
            return recipeRepository.getByNameV2(name);
        }

        if (ingredient != null) {
            System.out.println("My recipe name given the ingredient " + " " + ingredient);
            return recipeRepository.getByIngredient(ingredient);
        }

        if (instruction != null) {
            System.out.println("Given instruction name return recipes that have that instruction" + " " + instruction);
            return recipeRepository.getByInstruction(instruction);
        }
        return recipeRepository.getRecipes();
    }
}
