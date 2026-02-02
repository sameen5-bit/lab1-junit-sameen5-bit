import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for BeverageMachine.
 */
public class BeverageMachineUnitTest {

    @Test
    void recipeIsAddedSuccessfully() {
        BeverageMachine device = new BeverageMachine();
        DrinkRecipe drink = new DrinkRecipe(2, 2, 2);

        boolean wasAdded = device.addDrinkRecipe(drink);
        assertTrue(wasAdded);
    }

    @Test
    void addingRecipeFailsWhenStorageIsFull() {
        BeverageMachine device = new BeverageMachine();

        for (int slot = 0; slot < 4; slot++) {
            assertTrue(device.addDrinkRecipe(new DrinkRecipe(1, 1, 1)));
        }

        // Adding a fifth recipe should fail
        assertFalse(device.addDrinkRecipe(new DrinkRecipe(1, 1, 1)));
    }

    @Test
    void recipeCanBeRemovedSuccessfully() {
        BeverageMachine device = new BeverageMachine();
        device.addDrinkRecipe(new DrinkRecipe(1, 1, 1));

        assertTrue(device.deleteDrinkRecipe(0));
        assertFalse(device.deleteDrinkRecipe(0));
    }

    @Test
    void brewingReducesIngredientLevels() {
        BeverageMachine device = new BeverageMachine();
        device.addDrinkRecipe(new DrinkRecipe(2, 2, 2));

        assertTrue(device.prepareDrink(0));

        assertEquals(18, device.getCoffeeAmount());
        assertEquals(18, device.getMilkAmount());
        assertEquals(18, device.getSugarAmount());
    }

    @Test
    void brewingFailsWhenIngredientsAreInsufficient() {
        BeverageMachine device = new BeverageMachine();
        device.addDrinkRecipe(new DrinkRecipe(25, 1, 1));

        assertFalse(device.prepareDrink(0));
    }

    @Test
    void invalidIndexesCauseFailure() {
        BeverageMachine device = new BeverageMachine();

        assertFalse(device.prepareDrink(5));
        assertFalse(device.deleteDrinkRecipe(5));
    }
}