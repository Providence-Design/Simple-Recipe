package SimpleRecommendationSystem.recommendation.model;

public class Instructions {
    private int id;
    private String name;

    public Instructions(int id, String name) {
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
        return "Instructions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

