import java.util.Objects;
public class LitmusPaper extends Item implements Supplier,Material {
    public final int length;
    public LitmusPaper(int availableQuantity, double unitPrice,int length) {
        super(unitPrice, availableQuantity);
        this.length = length;
    }
    public int getLength(){
        return length;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LitmusPaper)) return false;
        if (!super.equals(o)) return false;
        LitmusPaper that = (LitmusPaper) o;
        return length == that.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }

    @Override
    public String toString() {
        return "LitmusPaper{" +
                "length=" + length +
                ", availableQuantity=" + availableQuantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
    @Override
    public boolean isSupplyNeeded() {
        return length * availableQuantity < 200;
    }
}


