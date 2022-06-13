package SimpleRecommendationSystem.recommendation.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructionRepository {
    private final JdbcTemplate jdbcTemplate;
    private final static String LIST_OF_INSTRUCTION_QUERY =
            "SELECT instruction.id, instruction.name" + " " +
                    "FROM recipe_instruction" + " " +
                    "INNER JOIN instruction ON instruction.id = recipe_instruction.instruction_id" + " " +
                    "WHERE recipe_instruction.recipe_id = ?";


    public InstructionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Instruction> getInstructionByRecipeId(int recipeId){
        return jdbcTemplate.query(LIST_OF_INSTRUCTION_QUERY, new InstructionMapper(), recipeId);
    }

}
