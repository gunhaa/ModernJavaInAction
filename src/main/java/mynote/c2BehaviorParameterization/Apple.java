package mynote.c2BehaviorParameterization;


public class Apple {

    private String name;

    private Integer weight;

    private Color color;

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", color=" + color +
                '}';
    }

    public Apple(String name, Integer weight, Color color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName(){
        return this.name;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public Color getColor() {
        return this.color;
    }
}
