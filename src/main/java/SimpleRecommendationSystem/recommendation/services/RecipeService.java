package SimpleRecommendationSystem.recommendation.services;

import SimpleRecommendationSystem.recommendation.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getRecipes(String name, String ingredient, String instruction);
}
