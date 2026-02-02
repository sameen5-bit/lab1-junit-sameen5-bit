/**
 * Represents a drink recipe.
 */
public class DrinkRecipe {

    private int coffeeAmount;
    private int milkAmount;
    private int sugarAmount;

    /**
     * Constructor.
     *
     * @param coffee amount of coffee
     * @param milk amount of milk
     * @param sugar amount of sugar
     */
    public DrinkRecipe(int coffee, int milk, int sugar) {
        this.coffeeAmount = coffee;
        this.milkAmount = milk;
        this.sugarAmount = sugar;
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }

    public int getMilkAmount() {
        return milkAmount;
    }

    public int getSugarAmount() {
        return sugarAmount;
    }
}