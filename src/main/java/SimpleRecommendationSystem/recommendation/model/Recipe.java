package SimpleRecommendationSystem.recommendation.model;

import java.sql.Array;

public class Recipe {
    private int id;
    private String cuisine;

    private String[] ingredients;


    public Recipe(int id, String cuisine, String[] ingredients) {
        this.id = id;
        this.cuisine = cuisine;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public String getCuisine() {
        return cuisine;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", cuisine='" + cuisine + '\'' +
                '}';
    }

    public String[] getIngredients() {
        return ingredients;
    }
}
