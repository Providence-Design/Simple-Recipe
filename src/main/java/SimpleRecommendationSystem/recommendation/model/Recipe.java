package SimpleRecommendationSystem.recommendation.model;


import SimpleRecommendationSystem.recommendation.services.Ingredient;

import java.util.List;

public class Recipe {
    private int id;
    private String cuisine;
    private List<Ingredient> ingredients;

    public Recipe(int id, String cuisine, List<Ingredient> ingredients) {
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
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

}