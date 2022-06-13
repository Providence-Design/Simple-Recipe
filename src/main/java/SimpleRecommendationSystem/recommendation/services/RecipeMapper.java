package SimpleRecommendationSystem.recommendation.services;

import SimpleRecommendationSystem.recommendation.model.Recipe;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RecipeMapper implements RowMapper<Recipe> {
    private final IngredientRepository ingredientRepository;
    private final InstructionRepository instructionRepository;

    public RecipeMapper(IngredientRepository ingredientRepository, InstructionRepository instructionRepository) {
        this.ingredientRepository = ingredientRepository;
        this.instructionRepository = instructionRepository;
    }

    @Override
    public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
         final int recipeId = rs.getInt("id");
         final String recipeName = rs.getString("cuisine");
         final List<Ingredient> recipeIngredients = ingredientRepository.getByRecipeId(recipeId);
         final List<Instruction> recipeInstructions = instructionRepository.getInstructionByRecipeId(recipeId);

        return  new Recipe(
                recipeId, recipeName, recipeIngredients, recipeInstructions
        );

    }
}
