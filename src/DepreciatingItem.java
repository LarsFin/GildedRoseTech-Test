public class DepreciatingItem extends QualityAlteringItem{

    DepreciatingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        super.updateQuality();
        decreaseItemQualityBy1();
        if (this.sellIn < 0) {
            decreaseItemQualityBy1();
        }
    }

}
