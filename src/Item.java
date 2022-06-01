import java.util.Objects;
public abstract class Item implements Supplier {
    public double unitPrice;
public int availableQuantity;

    public Item(double unitPrice, int availableQuantity) {
        this.unitPrice = unitPrice;
        this.availableQuantity = availableQuantity;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public int getAvailableQuantity(){return availableQuantity;}

    @Override
    public boolean isSupplyNeeded()
    {return false;}
    @Override
    public String toString(){
    return "availableQuantity " + availableQuantity +
            ", unitPrice " + unitPrice;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Double.compare(item.unitPrice, unitPrice) == 0 && availableQuantity == item.availableQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitPrice, availableQuantity);
    }


}

