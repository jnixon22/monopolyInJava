package monopoly;

public class Property extends DefaultSquare {

    private PropertyColor propertyColor;

    private int cost;

    public Property(String name, PropertyColor propertyColor, int cost) {
        super(name);
        this.propertyColor = propertyColor;
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                "color='" + propertyColor + '\'' +
                ", cost=" + cost +
                '}';
    }
}
