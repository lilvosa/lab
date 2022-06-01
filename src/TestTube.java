import java.util.Objects;

public class TestTube extends Item implements Supplier,Equipment {
    public final int width;
    public final int height;

    public TestTube(int availableQuantity, double unitPrice, int width, int height) {
        super(unitPrice, availableQuantity);
        if (width < 0 || width > 10) {
            throw new InvalidDataException("Invalid TestTube width: " + width + ". Width must between 0 to 10mm.");
        }
        if (height < 0 || height > 500) {
            throw new InvalidDataException("Invalid TestTube height: " + height + ". Height must between 0 to 500mm");
        }
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "TestTube{" +
                "availableQuantity=" + availableQuantity +
                ",unitPrice=" + unitPrice +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestTube)) return false;
        if (!super.equals(o)) return false;
        TestTube testTube = (TestTube) o;
        return getWidth() == testTube.getWidth() && getHeight() == testTube.getHeight();
    }
    @Override
    public boolean isSupplyNeeded() {
        return availableQuantity < 100;
    }
    }



