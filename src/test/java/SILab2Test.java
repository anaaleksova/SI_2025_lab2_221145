import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SILab2Test {

    @Test
    public void testEveryStatementCases() {
        // Test Case 1: allItems is null
        RuntimeException ex1 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "1234567812345678"));
        assertTrue(ex1.getMessage().contains("allItems list can't be null!"));

        // Test Case 2: Invalid item
        List<Item> items2 = List.of(new Item(null, 100, 0, 1));
        RuntimeException ex2 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items2, "1234567812345678"));
        assertTrue(ex2.getMessage().contains("Invalid item!"));

        // Test Case 3: Valid input, no discount, valid card
        List<Item> items3 = List.of(new Item("Book", 5, 100, 0.0));
        String card3 = "1234567812345678";
        double result3 = SILab2.checkCart(items3, card3);
        assertEquals(500, result3);

        // Test Case 4: Invalid card number
        List<Item> items5 = List.of(new Item("Pen", 10, 0, 1.0));
        RuntimeException ex5 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items5, null));
        assertTrue(ex5.getMessage().contains("Invalid card number!"));

        // Test Case 5: Invalid character in card number
        List<Item> items6 = List.of(new Item("Pen", 10, 0, 1));
        RuntimeException ex6 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items6, "1234abcd5678ABCD"));
        assertTrue(ex6.getMessage().contains("Invalid character in card number!"));
    }

    @Test
    public void testPriceDiscountQuantityCombinations() {
        // TC1: F F F
        double result1 = SILab2.checkCart(List.of(new Item("Item1", 1, 100, 0.0)), "1234567812345678");
        assertEquals(100, result1);

        // TC2: F F T
        double result2 = SILab2.checkCart(List.of(new Item("Item2", 15, 100, 0.0)), "1234567812345678");
        assertEquals(100 * 15 - 30, result2);

        // TC3: F T F
        double result3 = SILab2.checkCart(List.of(new Item("Item3", 1, 100, 0.2)), "1234567812345678");
        assertEquals(-30 + 100 * 0.8 * 1, result3);

        // TC4: T F F
        double result5 = SILab2.checkCart(List.of(new Item("Item5", 1, 400, 0.0)), "1234567812345678");
        assertEquals(400 - 30, result5);

    }
}
