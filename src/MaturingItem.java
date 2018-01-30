public class MaturingItem extends QualityAlteringItem {

    MaturingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        super.updateQuality();
        increaseItemQualityBy1();
        ageItemBy1();
        if (isMature()) { increaseItemQualityBy1(); }
    }

    public boolean isMature() {
        return(sellIn < 0);
    }

}
