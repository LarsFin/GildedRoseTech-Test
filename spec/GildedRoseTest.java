import org.junit.jupiter.api.*;

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

    @Nested
    @DisplayName("ItemQualityUpdateTests")
    class ItemQualityUpdateTests {

        @Test
        @DisplayName("Item quality cannot go below 0")
        void test1() {
            app.items.add(new Item("Item", 0, 0));
            app.updateQuality();
            assertEquals(0, app.items.get(0).quality);
        }

        @Test
        @DisplayName("Item's sellIn value should negate by 1 when updated")
        void test2() {
            app.items.add(new Item("Item", 5, 0));
            app.updateQuality();
            assertEquals(4, app.items.get(0).sellIn);
        }

        /*Should an item's sellIn value go below 0?
        Argument for:
            -Innkeeper may wan't to keep track of how many days an item is past it's sell by date
        Argument against:
            -There is no behaviour difference between an update on an item with sellIn 0 and one with sellIn -1
         */
        @Test
        @Disabled
        @DisplayName("Item's sellIn value should not go below 0")
        void test3() {
            app.items.add(new Item("Item", 0, 0));
            app.updateQuality();
            assertEquals(0, app.items.get(0).sellIn);
        }

        @Nested
        @DisplayName("StandardItems")
        class StandardItemTests {

            @Test
            @DisplayName("A standard item has it's quality negated by 1 when updated")
            public void test1() {
                app.items.add(new DepreciatingItem("Standard Item", 5, 10));
                app.updateQuality();
                assertEquals(9, app.items.get(0).quality);
            }

            @Test
            @DisplayName("A standard item has it's quality negated by 2 when past it's sellby date")
            public void test2() {
                app.items.add(new DepreciatingItem("Standard Item", 0, 10));
                app.updateQuality();
                assertEquals(8, app.items.get(0).quality);
            }

        }

        @Nested
        @DisplayName("MaturingItemsTests")
        class MaturingItemTests {

            @Test
            @DisplayName("A maturing item has it's quality increased by 1 when updated")
            public void test1() {
                app.items.add(new MaturingItem("Aged Brie", 10, 10));
                app.updateQuality();
                assertEquals(11, app.items.get(0).quality);
            }

            @Test
            @DisplayName("A maturing item has it's quality increased by 2 when updated past it's sellby date")
            public void test2() {
                app.items.add(new MaturingItem("Aged Brie", 0, 10));
                app.updateQuality();
                assertEquals(12, app.items.get(0).quality);
            }

            @Test
            @DisplayName("The quality of a maturing item can never go above 50")
            public void test3() {
                app.items.add(new MaturingItem("Aged Brie", 0, 50));
                app.updateQuality();
                assertEquals(50, app.items.get(0).quality);
            }

        }

        @Nested
        @DisplayName("ConcertItemTests")
        class ConcertItemTests {

            @Test
            @DisplayName("A concert item's value increases in quality by 1 when updated regardless of range")
            public void test1() {
                app.items.add(new ConcertItem("Backstage passes to a TAFKAL80ETC concert", 15, 10));
                app.updateQuality();
                assertEquals(11, app.items.get(0).quality);
            }

            @Test
            @DisplayName("A concert item's value increases in quality by 2 when updated within 10 days of the concert")
            public void test2() {
                app.items.add(new ConcertItem("Backstage passes to a TAFKAL80ETC concert", 8, 10));
                app.updateQuality();
                assertEquals(12, app.items.get(0).quality);
            }

            @Test
            @DisplayName("A concert item's value increases in quality by 3 when updated within 5 days of the concert")
            public void test3() {
                app.items.add(new ConcertItem("Backstage passes to a TAFKAL80ETC concert", 5, 10));
                app.updateQuality();
                assertEquals(13, app.items.get(0).quality);
            }

            @Test
            @DisplayName("A concert item's value is set to 0 when past it's sellby date")
            public void test4() {
                app.items.add(new ConcertItem("Backstage passes to a TAFKAL80ETC concert", 0, 10));
                app.updateQuality();
                assertEquals(0, app.items.get(0).quality);
            }

            @Test
            @DisplayName("The quality of a concert ticket can't go above 50")
            public void test5() {
                app.items.add(new ConcertItem("Backstage passes to a TAFKAL80ETC concert", 4, 50));
                app.updateQuality();
                assertEquals(50, app.items.get(0).quality);
            }

        }

        @Nested
        @DisplayName("LegendaryItemTests")
        class LegendaryItemTests {

            @Test
            @DisplayName("A legendary item never has it's quality altered")
            public void test1() {
                app.items.add(new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80));
                app.updateQuality();
                assertEquals(80, app.items.get(0).quality);
            }

            @Test
            @DisplayName("A legendary item never has to be sold")
            public void test2() {
                app.items.add(new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80));
                app.updateQuality();
                assertEquals(0, app.items.get(0).sellIn);
            }

        }

    }

}
