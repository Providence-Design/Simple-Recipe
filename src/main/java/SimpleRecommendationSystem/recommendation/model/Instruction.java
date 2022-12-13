package SimpleRecommendationSystem.recommendation.model;

public class Instruction {
    private int id;
    private String name;

    public Instruction(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Instruction() {
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
