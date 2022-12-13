package SimpleRecommendationSystem.recommendation.query;

public final class InstructionQuery {

    public static final String INSTRUCTION_QUERY =
            "SELECT instruction.name, recipe.cuisine AS cuisine, instruction.id" + " " +
                    "FROM instruction" + " " +
                    "INNER JOIN recipe_instruction ON instruction.id = recipe_instruction.instruction_id" + " " +
                    "INNER JOIN recipe ON recipe.id = recipe_instruction.recipe_id" + " " +
                    "WHERE instruction.name = ?";

    public final static String LIST_OF_INSTRUCTION_QUERY =
            "SELECT instruction.id, instruction.name" + " " +
                    "FROM recipe_instruction" + " " +
                    "INNER JOIN instruction ON instruction.id = recipe_instruction.instruction_id" + " " +
                    "WHERE recipe_instruction.recipe_id = ?";
}
