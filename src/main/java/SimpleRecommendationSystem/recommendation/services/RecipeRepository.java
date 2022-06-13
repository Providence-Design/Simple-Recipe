package SimpleRecommendationSystem.recommendation.services;

import SimpleRecommendationSystem.recommendation.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeRepository {
    private final IngredientRepository ingredientRepository;
    private final InstructionRepository instructionRepository;
    private final JdbcTemplate jdbcTemplate;
    private final String INSTRUCTION_QUERY =
            "SELECT instruction.name, recipe.cuisine AS cuisine, instruction.id" + " " +
                    "FROM instruction" + " " +
                    "INNER JOIN recipe_instruction ON instruction.id = recipe_instruction.instruction_id" + " " +
                    "INNER JOIN recipe ON recipe.id = recipe_instruction.recipe_id" + " " +
                    "WHERE instruction.name = ?";

    private final String RECIPE_QUERY =
            "SELECT ingredient.id, ingredient.name, recipe.cuisine AS cuisine, recipe.id AS id FROM recipe" + " " +
                    "INNER JOIN recipe_ingredient ON recipe.id = recipe_ingredient.recipe_id" + " " +
                    "INNER JOIN ingredient ON ingredient.id = recipe_ingredient.ingredient_id" + " " +
                    "WHERE cuisine = ?";

    private final String INGREDIENT_QUERY =
            "SELECT ingredient.name, recipe.cuisine AS cuisine, recipe.id AS id, ingredient.id" + " " +
                    "FROM ingredient" + " " +
                    "INNER JOIN recipe_ingredient ON ingredient.id = recipe_ingredient.ingredient_id" + " " +
                    "INNER JOIN recipe ON recipe.id = recipe_ingredient.recipe_id" + " " +
                    "WHERE ingredient.name = ?";
//            "SELECT *" + " " +
//                    "FROM recipe_ingredient" + " " +
//                    "INNER JOIN recipe ON recipe.id = recipe_ingredient.recipe_id" + " " +
//                    "INNER JOIN ingredient ON ingredient.id = recipe_ingredient.ingredient_id" + " " +
//                    "WHERE ingredient.name = ?";


    public RecipeRepository(IngredientRepository ingredientRepository, InstructionRepository instructionRepository, JdbcTemplate jdbcTemplate) {
        this.ingredientRepository = ingredientRepository;
        this.instructionRepository = instructionRepository;
        this.jdbcTemplate = jdbcTemplate;
//        loadData();
    }


    public List<Recipe> getRecipes() {
        List<Recipe> recipes = jdbcTemplate.query("SELECT * FROM recipe", new RecipeMapper(ingredientRepository, instructionRepository));
        System.out.println(recipes);
        return recipes;
    }

    public List<Recipe> getByName(String recipe) {
        List<Recipe> recipeName = jdbcTemplate.query("SELECT * FROM recipe WHERE cuisine = ? ", new RecipeMapper(ingredientRepository, instructionRepository), recipe);
        System.out.println(recipeName);
        return recipeName;
    }

    public List<Recipe> getByNameV2(String name) {
//        List<Ingredient> ingredients = jdbcTemplate.query(RECIPE_QUERY, new IngredientMapper(), name);
//        System.out.println(ingredients);
//        List<Recipe> recipeList = new ArrayList<>();
//        recipeList.add(new Recipe(1, name, ingredients));
//
//        return recipeList;
        return jdbcTemplate.query(RECIPE_QUERY, new RecipeMapper(ingredientRepository, instructionRepository), name);
    }


    public List<Recipe> getByIngredient(String ingredient) {
        return jdbcTemplate.query(INGREDIENT_QUERY, new RecipeMapper(ingredientRepository, instructionRepository), ingredient);

    }

    public List<Recipe> getByInstruction(String instruction){
        return jdbcTemplate.query(INSTRUCTION_QUERY,new RecipeMapper(ingredientRepository, instructionRepository), instruction);
    }
}
