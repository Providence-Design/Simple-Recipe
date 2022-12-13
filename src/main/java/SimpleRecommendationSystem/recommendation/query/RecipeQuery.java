package SimpleRecommendationSystem.recommendation.query;


public final class RecipeQuery {

    public static final String RECIPE_QUERY =
            "SELECT ingredient.id, ingredient.name, recipe.cuisine AS cuisine, recipe.id AS id FROM recipe" + " " +
                    "INNER JOIN recipe_ingredient ON recipe.id = recipe_ingredient.recipe_id" + " " +
                    "INNER JOIN ingredient ON ingredient.id = recipe_ingredient.ingredient_id" + " " +
                    "WHERE cuisine = ?";

    public static final String CUISINE_QUERY =   "SELECT * FROM recipe WHERE cuisine = ? ";

    public static  final String REC_QUERY = "SELECT * FROM recipe";
}
