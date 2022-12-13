package SimpleRecommendationSystem.recommendation.services;

public class Instruction {
    private final int id;
    private final String name;

    public Instruction(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
