import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    ArrayList<Item> items;
    GildedRose app;

    @BeforeEach
    void setupGildedRose() {
        items = new ArrayList<>();
        app = new GildedRose(items);
    }

    @Nested
    @DisplayName("ItemInstantiationTests")
    class ItemInstantiationTests {

        @BeforeEach
        void addItemArcaniteReaper() {
            app.items.add(new Item("Arcanite Reaper", 25, 5));
        }

        @Test
        @DisplayName("Item has a name")
        public void test1() {
            assertEquals("Arcanite Reaper", app.items.get(0).name);
        }

        @Test
        @DisplayName("Item has a sellIn value as an integer")
        public void test2() {
            assertEquals(25, app.items.get(0).sellIn);
        }

        @Test
        @DisplayName("Item has a quality value that's an integer")
        public void test3() {
            assertEquals(5, app.items.get(0).quality);
        }

    }

}
