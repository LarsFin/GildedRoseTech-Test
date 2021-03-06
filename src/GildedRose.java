import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class GildedRose {

    ArrayList<Item> items;

    public GildedRose(ArrayList<Item> items) {
        this.items = items;
    }

    public void updateSellIn() {

        for(Item item: items) {

            try {
                ((QualityAlteringItem) item).updateSellIn();
            } catch(Exception e) {
                System.out.println(e.toString());
            }

        }

    }

    public void updateQuality() {

        for(Item item: items) {

            try {
                ((QualityAlteringItem) item).updateQuality();
            } catch(Exception e) {
               System.out.println(e.toString());
            }

        }

    }

    public void dayPasses() {

        updateSellIn();
        updateQuality();

    }

}
