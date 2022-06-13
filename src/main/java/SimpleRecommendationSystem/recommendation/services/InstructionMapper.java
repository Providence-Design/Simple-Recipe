package SimpleRecommendationSystem.recommendation.services;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InstructionMapper implements RowMapper<Instruction> {
    @Override
    public Instruction mapRow(ResultSet rs, int rowNum) throws SQLException {
        Instruction instruction = new Instruction(
                rs.getInt("id"),
                rs.getString("name")
        );

        return instruction;

    }
}
