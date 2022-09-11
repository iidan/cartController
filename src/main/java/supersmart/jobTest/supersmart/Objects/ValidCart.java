package supersmart.jobTest.supersmart.Objects;

public class ValidCart {

    boolean validWeight;
    boolean validWeightItemsSection;
    boolean validGreenItems;

    public ValidCart(boolean validWeight, boolean validWeightItemsSection, boolean validGreenItems) {
        this.validWeight = validWeight;
        this.validWeightItemsSection = validWeightItemsSection;
        this.validGreenItems = validGreenItems;
    }

    public boolean isValidWeight() {
        return validWeight;
    }

    public boolean isValidWeightItemsSection() {
        return validWeightItemsSection;
    }

    public boolean isValidGreenItems() {
        return validGreenItems;
    }

}
