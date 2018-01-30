public class DummyItem extends QualityAlteringItem{

    boolean updateSellInCalled;
    boolean updateQualityCalled;

    DummyItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.updateSellInCalled = false;
        this.updateQualityCalled = false;
    }

    void updateQuality() {
        this.updateQualityCalled = true;
    }

    void updateSellIn() {
        this.updateSellInCalled = true;
    }

}
