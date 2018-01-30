import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GildedRoseTest {

    ArrayList<Item> items;
    GildedRose app;
    DummyItem trainingDummy;

    @BeforeEach
    void setup() {
        items = new ArrayList<>();
        app = new GildedRose(items);
        trainingDummy = new DummyItem("Training Dummy", 0, 0);
    }

    @Test
    @DisplayName("When having updateSellIn called it calls the method updateSellIn on an Item within the Items" +
            "array")
    void test1() {
        app.items.add(trainingDummy);
        assertFalse(trainingDummy.updateSellInCalled);
        app.updateSellIn();
        assertTrue(trainingDummy.updateSellInCalled);
    }

    @Test
    @DisplayName("When having updateQuality called it calls the method updateQuality on an Item within the Items" +
            "array")
    void test2() {
        app.items.add(trainingDummy);
        assertFalse(trainingDummy.updateQualityCalled);
        app.updateQuality();
        assertTrue(trainingDummy.updateQualityCalled);
    }

    @Test
    @DisplayName("When a day passes at the Gilded Rose both the updateSellIn method and the updateQuality method of" +
            "each item in the Items array is called")
    void test3() {
        app.items.add(trainingDummy);
        assertFalse(trainingDummy.updateQualityCalled);
        assertFalse(trainingDummy.updateSellInCalled);
        app.dayPasses();
        assertTrue(trainingDummy.updateQualityCalled);
        assertTrue(trainingDummy.updateSellInCalled);
    }

}
