public class ConcertItem extends QualityAlteringItem{

    ConcertItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        super.updateQuality();
        int value = this.value();
        for(int i = value; i > 0; i--) {
            increaseItemQualityBy1();
        }
    }

    private int value() {
        if (isBetween(this.sellIn, 1, 5)) {
            return 3;
        } else if(isBetween(this.sellIn, 6, 10)) {
            return 2;
        } else if(this.sellIn > 10){
            return 1;
        } else {
            this.quality = 0;
            return 0;
        }
    }

    private static boolean isBetween(int arg, int bottom,int top) {
        return (arg >= bottom && arg <= top);
    }

}
