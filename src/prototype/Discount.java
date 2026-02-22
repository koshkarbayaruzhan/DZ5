package prototype;

public class Discount implements Cloneable {

    private String name;
    private double value;

    public Discount(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public Discount clone() {
        try {
            return (Discount) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return name + " - " + value + "%";
    }
}
