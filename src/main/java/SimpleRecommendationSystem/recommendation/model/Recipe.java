package SimpleRecommendationSystem.recommendation.model;


import SimpleRecommendationSystem.recommendation.services.Ingredient;
import SimpleRecommendationSystem.recommendation.services.Instruction;

import java.util.List;

public class Recipe {
    private int id;
    private String cuisine;
    private List<Ingredient> ingredients;
    private List<Instruction> instructions;

    public Recipe(int id, String cuisine, List<Ingredient> ingredients, List<Instruction> instructions) {
        this.id = id;
        this.cuisine = cuisine;
        this.ingredients = ingredients;
        this.instructions = instructions;
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
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                '}';
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    public List<Instruction> getInstructions() {
        return instructions;
    }

}