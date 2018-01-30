public class ConjuredItem extends DepreciatingItem{

    ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        super.updateQuality();
        super.updateQuality();
    }

}
