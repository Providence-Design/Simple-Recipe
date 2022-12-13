package SimpleRecommendationSystem.recommendation.repository;

import SimpleRecommendationSystem.recommendation.model.Recipe;
import SimpleRecommendationSystem.recommendation.query.IngredientQuery;
import SimpleRecommendationSystem.recommendation.query.InstructionQuery;
import SimpleRecommendationSystem.recommendation.query.RecipeQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecipeRepository {

    private final IngredientRepository ingredientRepository;
    private final InstructionRepository instructionRepository;
    private final JdbcTemplate jdbcTemplate;

    public RecipeRepository(IngredientRepository ingredientRepository, InstructionRepository instructionRepository, JdbcTemplate jdbcTemplate) {
        this.ingredientRepository = ingredientRepository;
        this.instructionRepository = instructionRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Recipe> getRecipes() {
        List<Recipe> recipes = jdbcTemplate.query(RecipeQuery.REC_QUERY, new RecipeMapper(ingredientRepository, instructionRepository));
        System.out.println(recipes);
        return recipes;
    }

    public List<Recipe> getByName(String recipe) {
        return jdbcTemplate.query(RecipeQuery.CUISINE_QUERY, new RecipeMapper(ingredientRepository, instructionRepository), recipe);
    }

    public List<Recipe> getByNameV2(String name) {
        return jdbcTemplate.query(RecipeQuery.RECIPE_QUERY, new RecipeMapper(ingredientRepository, instructionRepository), name);
    }


    public List<Recipe> getByIngredient(String ingredient) {
        return jdbcTemplate.query(IngredientQuery.INGREDIENT_QUERY, new RecipeMapper(ingredientRepository, instructionRepository), ingredient);

    }

    public List<Recipe> getByInstruction(String instruction){
        return jdbcTemplate.query(InstructionQuery.INSTRUCTION_QUERY,new RecipeMapper(ingredientRepository, instructionRepository), instruction);
    }
}
