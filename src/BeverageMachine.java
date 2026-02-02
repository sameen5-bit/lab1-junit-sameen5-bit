/**
 * Beverage machine simulator that manages recipes and ingredient levels.
 */
public class BeverageMachine {

    private static final int MAX_RECIPES = 4;

    private DrinkRecipe[] recipeStorage;
    private int coffeeAmount;
    private int milkAmount;
    private int sugarAmount;

    /**
     * Initializes the machine with full ingredients and no recipes.
     */
    public BeverageMachine() {
        recipeStorage = new DrinkRecipe[MAX_RECIPES];
        coffeeAmount = 20;
        milkAmount = 20;
        sugarAmount = 20;
    }

    /**
     * Adds a recipe if space is available.
     *
     * @param recipe the recipe to add
     * @return true if added, false otherwise
     */
    public boolean addDrinkRecipe(DrinkRecipe recipe) {
        for (int i = 0; i < MAX_RECIPES; i++) {
            if (recipeStorage[i] == null) {
                recipeStorage[i] = recipe;
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a recipe at the given index.
     *
     * @param index recipe position
     * @return true if removal succeeded, false otherwise
     */
    public boolean deleteDrinkRecipe(int index) {
        if (index < 0 || index >= MAX_RECIPES) {
            return false;
        }

        if (recipeStorage[index] != null) {
            recipeStorage[index] = null;
            return true;
        }

        return false;
    }

    /**
     * Attempts to prepare a drink using a stored recipe.
     *
     * @param index recipe index
     * @return true if preparation succeeded, false otherwise
     */
    public boolean prepareDrink(int index) {
        if (index < 0 || index >= MAX_RECIPES) {
            return false;
        }

        DrinkRecipe selectedRecipe = recipeStorage[index];
        if (selectedRecipe == null) {
            return false;
        }

        if (coffeeAmount >= selectedRecipe.getCoffeeAmount() &&
            milkAmount >= selectedRecipe.getMilkAmount() &&
            sugarAmount >= selectedRecipe.getSugarAmount()) {

            coffeeAmount -= selectedRecipe.getCoffeeAmount();
            milkAmount -= selectedRecipe.getMilkAmount();
            sugarAmount -= selectedRecipe.getSugarAmount();

            return true;
        }

        return false;
    }

    /**
     * Gets the current coffee amount in the machine.
     *
     * @return the amount of coffee available
     */
    public int getCoffeeAmount() {
        return coffeeAmount;
    }

    /**
     * Gets the current milk amount in the machine.
     *
     * @return the amount of milk available
     */
    public int getMilkAmount() {
        return milkAmount;
    }

    /**
     * Gets the current sugar amount in the machine.
     *
     * @return the amount of sugar available
     */
    public int getSugarAmount() {
        return sugarAmount;
    }
}