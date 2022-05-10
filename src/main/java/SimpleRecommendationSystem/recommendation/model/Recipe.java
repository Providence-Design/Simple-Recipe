package SimpleRecommendationSystem.recommendation.model;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Recipe {
    @Id

    private Long id;
    private String cuisine;
    private List<String> ingredients = new ArrayList<String>();
    private List<String> instructions = new ArrayList<String>();


    public Recipe(Long id, String cuisine, List<String> ingredients, List<String> instructions) {
        this.id = id;
        this.cuisine = cuisine;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }
}
