package SimpleRecommendationSystem.recommendation.services;

import SimpleRecommendationSystem.recommendation.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeRepository {
    private JdbcTemplate jdbcTemplate;

    public RecipeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
//        loadData();
    }


    public List<Recipe> getRecipes() {
        List<Recipe> recipes = jdbcTemplate.query("SELECT * FROM recipe", new RecipeMapper());
        System.out.println(recipes);
        return recipes;
    }
}
