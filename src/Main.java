import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException  {

        Laboratory laboratory;
        try {
            laboratory = new Laboratory(Paths.get("src/Products" ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Initial list of Items: ");
        System.out.println(laboratory);

        laboratory.addItem(new TestTube(5, 10,  3, 50));
        System.out.println("Adjusted list of Items: ");
        System.out.println(laboratory);

        System.out.println("Total price of available equipment: " + laboratory.getTotalPriceOfAvailableEquipment());

        System.out.println("Items that need supply: ");
        System.out.println(laboratory.getItemsThatNeedSupply());

        System.out.println("Average price of available materials: " + laboratory.getAveragePriceOfAvailableMaterials());

        System.out.println("Items ordered by price: ");
        System.out.println(laboratory.getItemsOrderedByPrice());

        System.out.println("The cheapest litmus solution: " + laboratory.getTheCheapestLitmusSolution());

        System.out.println("The most expensive Item: " + laboratory.getTheMostExpensiveItem());
    }
}
