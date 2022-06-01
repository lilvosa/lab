import java.util.Objects;

public class LitmusSolution extends Item implements Supplier,Material {
    public final double volume;
    public LitmusSolution(int availableQuantity, double unitPrice, double volume){
        super(unitPrice, availableQuantity);
        this.volume= volume;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "LitmusSolution{" +
                "volume=" + volume +
                ", availableQuantity=" + availableQuantity +
                ", unitPrice=" + unitPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LitmusSolution)) return false;
        if (!super.equals(o)) return false;
        LitmusSolution that = (LitmusSolution) o;
        return volume == that.volume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVolume());
    }
}
