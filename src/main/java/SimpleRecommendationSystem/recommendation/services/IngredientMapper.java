package SimpleRecommendationSystem.recommendation.services;

import SimpleRecommendationSystem.recommendation.model.Ingredients;
import SimpleRecommendationSystem.recommendation.model.Recipe;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientMapper implements RowMapper<Ingredient> {
    @Override
    public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ingredient ingredient = new Ingredient(
                rs.getInt("id"),
                rs.getString("name")

        );

        return ingredient;

    }
}
