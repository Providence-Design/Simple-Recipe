package SimpleRecommendationSystem.recommendation.repository;

import SimpleRecommendationSystem.recommendation.model.Ingredient;
import SimpleRecommendationSystem.recommendation.query.IngredientQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IngredientRepository {

    private final JdbcTemplate jdbcTemplate;

    public IngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Ingredient> getByRecipeId(int recipeId) {
        return jdbcTemplate.query(IngredientQuery.LIST_OF_INGREDIENT_QUERY, new IngredientMapper(), recipeId);
    }
}
