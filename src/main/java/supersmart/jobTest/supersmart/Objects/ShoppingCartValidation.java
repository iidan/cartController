package supersmart.jobTest.supersmart.Objects;

import org.springframework.stereotype.Component;
import supersmart.jobTest.supersmart.ItemType;
import supersmart.jobTest.supersmart.Utils.Utils;

import java.util.List;

@Component
public class ShoppingCartValidation {

    //total items weight is above 40 kilograms
    private final Float MAX_WEIGHT = 40f;

    //weighted items in the transactions, above 10 kilograms
    private final Float MAX_WEIGHTED_ITEMS = 10f;

    //passed only if at least 2 out of 3 processes are passed.
    private final Integer MIN_TRUE_ITEMS = 2;

    public boolean cartShoppingValidation(List<Item> items) {

        ValidCart validCart = new ValidCart(
                isTotalItemsWeightAboveXKilograms(items),
                weightedTransactions(items),
                isGreenItemsBarcodeStartingWith(items, "29")
        );

        return Utils.checkAmountOfTrueValues(validCart.isValidGreenItems(),
                validCart.isValidWeight(),
                validCart.isValidWeightItemsSection())
                >= MIN_TRUE_ITEMS;
    }

    private boolean isTotalItemsWeightAboveXKilograms(List<Item> items) {
        double totalWeight = items.stream().mapToDouble(item -> (item.getWeight() != null) ? item.getWeight() : 0).sum();
        return totalWeight > MAX_WEIGHT;
    }

    private boolean weightedTransactions(List<Item> items) {
        double totalWeight = items.stream().mapToDouble(item -> (
                item.getWeight() != null && item.getType() == ItemType.WeightedItem.getType())
                ? item.getWeight()
                : 0
        ).sum();
        return !(totalWeight > MAX_WEIGHTED_ITEMS);
    }

    private boolean isGreenItemsBarcodeStartingWith(List<Item> items, String prefix) {
        boolean isGreenItemFound = items.stream()
                .filter(item -> item.getType() == ItemType.GreenItem.getType())
                .anyMatch(item -> item.getBarcode() != null && Utils.checkNumberPrefix(item.getBarcode(), prefix));
        return !isGreenItemFound;
    }
}
