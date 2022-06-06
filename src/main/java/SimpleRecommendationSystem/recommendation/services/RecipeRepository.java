package SimpleRecommendationSystem.recommendation.services;

import SimpleRecommendationSystem.recommendation.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeRepository {
    private JdbcTemplate jdbcTemplate;
    private final String RECIPE_QUERY =
            "SELECT ingredient.id, ingredient.name FROM recipe" + " " +
                    "INNER JOIN recipe_ingredient ON recipe.id = recipe_ingredient.recipe_id" + " " +
                    "INNER JOIN ingredient ON ingredient.id = recipe_ingredient.ingredient_id" + " " +
                    "WHERE cuisine = ?";

    private final String INGREDIENT_QUERY =
            "SELECT ingredient.name, recipe.cuisine AS cuisine, recipe.id AS id, ingredient.id" + " " +
                    "FROM ingredient" + " " +
                    "INNER JOIN recipe_ingredient ON ingredient.id = recipe_ingredient.ingredient_id" + " " +
                    "INNER JOIN recipe ON recipe.id = recipe_ingredient.recipe_id" + " " +
                    "WHERE ingredient.name = ?";


    public RecipeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
//        loadData();
    }


    public List<Recipe> getRecipes() {
        List<Recipe> recipes = jdbcTemplate.query("SELECT * FROM recipe", new RecipeMapper());
        System.out.println(recipes);
        return recipes;
    }

    public List<Recipe> getByName(String recipe) {
        List<Recipe> recipeName = jdbcTemplate.query("SELECT * FROM recipe WHERE cuisine = ? ", new RecipeMapper(), new Object[]{recipe});
        System.out.println(recipeName);
        return recipeName;
    }

    public List<Recipe> getByNameV2(String recipe) {
        List<Ingredient> ingredients = jdbcTemplate.query(RECIPE_QUERY, new IngredientMapper(), new Object[]{recipe});
        System.out.println(ingredients);
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe(1, recipe, ingredients));

        return recipeList;
    }


    public List<Recipe> getByIngredient(String ingredient) {
        List<Recipe> recipeList = jdbcTemplate.query(INGREDIENT_QUERY, new RecipeMapper(), new Object[]{ingredient});

        return recipeList;

    }

}
