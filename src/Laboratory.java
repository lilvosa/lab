import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.lang.String;

public class Laboratory {

    public final List<Item> items = new ArrayList<>();

    public Laboratory(Path products) throws IOException {
        Files.lines(products).forEach((line) -> {
            List<String> params = Arrays.stream(line.split(",")).map(String::trim).collect(Collectors.toList());

            switch (params.get(0)) {
                case "Test tube": {
                    if (params.size() != 5) {
                        throw new InvalidDataException("Invalid data format: " + line);
                    }
                    try {
                        items.add(new TestTube(
                                Integer.parseInt(params.get(1)),
                                (double) Integer.parseInt(params.get(2)),
                                (int) Double.parseDouble(params.get(3)),
                                Integer.parseInt(params.get(4))
                        ));
                    } catch (Exception e) {
                        throw new InvalidDataException("Invalid data format: " + line);
                    }
                    break;
                }
                case "Volume Flask": {
                    if (params.size() != 4) {
                        throw new InvalidDataException("Invalid data format: " + line);
                    }
                    try {
                        items.add(new VolumeFlask(
                                Integer.parseInt(params.get(1)),
                                Double.parseDouble(params.get(2)),
                                Integer.parseInt(params.get(3))
                        ));
                    } catch (Exception e) {
                        throw new InvalidDataException("Invalid data format: " + line);
                    }
                    break;
                }
                case "Microscope": {
                    if (params.size() != 5) {
                        throw new InvalidDataException("Invalid data format: " + line);
                    }
                    try {
                        items.add(new Microscope(
                                params.get(1),
                                Microscope.Type.valueOf(params.get(2)),
                                Double.parseDouble(params.get(3)),
                                Integer.parseInt(params.get(4))
                        ));
                    } catch (Exception e) {
                        throw new InvalidDataException("Invalid data format: " + line);
                    }
                    break;

                }
                case "Litmus Paper": {
                    if (params.size() != 4) {
                        throw new InvalidDataException("Invalid data format: " + line);
                    }
                    try {
                        items.add(new LitmusPaper(
                                Integer.parseInt(params.get(1)),
                                Double.parseDouble(params.get(2)),
                                Integer.parseInt(params.get(3))
                        ));
                    } catch (Exception e) {
                        throw new InvalidDataException("Invalid data format: " + line);
                    }
                    break;
                }
                case "Litmus Solution": {
                    if (params.size() != 4) {
                        throw new InvalidDataException("Invalid data format: " + line);
                    }
                    try {
                        items.add(new LitmusSolution(
                                Integer.parseInt(params.get(1)),
                                Double.parseDouble(params.get(2)),
                                Integer.parseInt(params.get(3))
                        ));
                    } catch (Exception e) {
                        throw new InvalidDataException("Invalid data format: " + line);
                    }
                    break;
                }
                default: {
                    throw new InvalidDataException("Unknown item: " + line);
                }
            }
        });
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double getTotalPriceOfAvailableEquipment() {
        return items.stream()
                .filter(item -> item instanceof Equipment)
                .mapToDouble(item -> item.getAvailableQuantity() * item.getUnitPrice())
                .sum();
    }

    public List<Item> getItemsThatNeedSupply() {
        return items.stream()
                .filter(Item::isSupplyNeeded)
                .collect(Collectors.toList());
    }

    public double getAveragePriceOfAvailableMaterials() {
        return items.stream()
                .filter(item -> item instanceof Material)
                .mapToDouble(item -> item.getAvailableQuantity() * item.getUnitPrice())
                .average()
                .orElse(0.0);
    }

    public List<Item> getItemsOrderedByPrice() {
        return items.stream()
                .sorted(Comparator.comparingDouble(item -> item.getAvailableQuantity() * item.getUnitPrice()))
                .collect(Collectors.toList());
    }

    public Optional<Item> getTheCheapestLitmusSolution() {
        return items.stream()
                .filter(item -> item instanceof LitmusSolution)
                .min(Comparator.comparingDouble(Item::getUnitPrice));
    }

    public Optional<Item> getTheMostExpensiveItem() {
        return items.stream()
                .max(Comparator.comparingDouble(item -> item.getAvailableQuantity() * item.getUnitPrice()));
    }

    @Override
    public String toString() {
        return "Laboratory{" +
                "items=" + items +
                '}';
    }
}


