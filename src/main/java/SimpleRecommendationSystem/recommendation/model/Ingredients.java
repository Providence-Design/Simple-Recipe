package SimpleRecommendationSystem.recommendation.model;

public class Ingredients {
    private int id;
    private String name;

    public Ingredients(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
