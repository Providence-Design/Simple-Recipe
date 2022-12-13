package SimpleRecommendationSystem.recommendation.query;

public final class IngredientQuery {

    public static final String INGREDIENT_QUERY =
            "SELECT ingredient.name, recipe.cuisine AS cuisine, recipe.id AS id, ingredient.id" + " " +
                    "FROM ingredient" + " " +
                    "INNER JOIN recipe_ingredient ON ingredient.id = recipe_ingredient.ingredient_id" + " " +
                    "INNER JOIN recipe ON recipe.id = recipe_ingredient.recipe_id" + " " +
                    "WHERE ingredient.name = ?";


    public final static String LIST_OF_INGREDIENT_QUERY =
            " SELECT ingredient.id, ingredient.name" + " " +
                    "FROM recipe_ingredient" + " " +
                    "INNER JOIN ingredient ON ingredient.id = recipe_ingredient.ingredient_id" + " " +
                    "WHERE recipe_ingredient.recipe_id = ?";

}
