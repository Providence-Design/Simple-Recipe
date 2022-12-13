package SimpleRecommendationSystem.recommendation.repository;

import SimpleRecommendationSystem.recommendation.model.Instruction;
import SimpleRecommendationSystem.recommendation.query.InstructionQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructionRepository {

    private final JdbcTemplate jdbcTemplate;

    public InstructionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Instruction> getInstructionByRecipeId(int recipeId){
        return jdbcTemplate.query(InstructionQuery.LIST_OF_INSTRUCTION_QUERY, new InstructionMapper(), recipeId);
    }

}
