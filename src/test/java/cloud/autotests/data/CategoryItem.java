package cloud.autotests.data;

public enum CategoryItem {
    BOOKS("Books"),
    COMPUTERS("Computers"),
    ELECTRONICS("Electronics"),
    APPAREL_SHOES("Apparel & Shoes"),
    DIGITAL_DOWNLOADS("Digital downloads"),
    JEWELRY("Jewelry"),
    GIFT_CARDS("Gift Cards");

    private final String displayedName;

    CategoryItem(String displayedName) {
        this.displayedName = displayedName;
    }

    public String getDisplayedName() {
        return displayedName;
    }
}