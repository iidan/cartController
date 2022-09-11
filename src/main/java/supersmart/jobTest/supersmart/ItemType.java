package supersmart.jobTest.supersmart;

public enum ItemType {

    UnitItem(1),
    WeightedItem(2),
    GreenItem(3);

    private final int type;

    ItemType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
