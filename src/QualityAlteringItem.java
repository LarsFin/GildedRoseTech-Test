public class QualityAlteringItem extends Item{

    QualityAlteringItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    void updateQuality() {
    }

    void decreaseItemQualityBy1() {
        if(quality > 0) {
            this.quality -= 1;
        }
    }

    void increaseItemQualityBy1() {
        if(quality < 50) {
            this.quality += 1;
        }
    }

    void updateSellIn() {
        ageItemBy1();
    }

    void ageItemBy1() {
        this.sellIn -= 1;
    }

}
