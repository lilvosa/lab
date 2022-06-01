import java.util.Objects;

public class Microscope extends Item implements Equipment {

    public enum Type {

        Electronic, Optical
    }

    private String brand;

    private Type type;

    public Microscope(String brand, Type type, double unitPrice, int availableQuantity) {
        super(unitPrice, availableQuantity);
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean isSupplyNeeded() {
        return type.equals(Type.Electronic) && availableQuantity == 0;
    }

    @Override
    public String toString() {
        return "Microscope{" +
                "brand='" + brand + '\'' +
                ", type=" + type +
                ", unitPrice=" + unitPrice +
                ", availableQuantity=" + availableQuantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Microscope)) return false;
        if (!super.equals(o)) return false;
        Microscope that = (Microscope) o;
        return brand.equals(that.brand) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brand, type);
    }
}
