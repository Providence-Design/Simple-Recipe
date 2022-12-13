package SimpleRecommendationSystem.recommendation.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IngredientRepository {
    private final JdbcTemplate jdbcTemplate;
    private final static String LIST_OF_INGREDIENT_QUERY =
            " SELECT ingredient.id, ingredient.name" + " " +
                    "FROM recipe_ingredient" + " " +
                    "INNER JOIN ingredient ON ingredient.id = recipe_ingredient.ingredient_id" + " " +
                    "WHERE recipe_ingredient.recipe_id = ?";

    public IngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }
    public List<Ingredient> getByRecipeId(int recipeId) {
        return jdbcTemplate.query(LIST_OF_INGREDIENT_QUERY, new IngredientMapper(), recipeId);

    }


}
