public class Food {

    // Instance variables
    private String name;
    private double calories;
    private String[] ingredients;
    private double price;

    // Constructor
    public Food(String name, double calories, String[] ingredients, double price) {
        this.name = name;
        this.calories = calories;
        this.ingredients = ingredients;
        this.price = price;
    }

    // Getter methods
    public String getName() {
        return this.name;
    }

    public double getCalories() {
        return this.calories;
    }

    public String[] getIngredients() {
        return this.ingredients;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        String rtn = this.name;
        rtn += "\nPrice: $" + String.valueOf(this.price) + "0\nCalories: " + String.valueOf(this.calories) + "\nIngredients: ";
        for (String s : this.ingredients) {
            rtn += s + ", ";
        }
        return rtn.substring(0, rtn.length() - 2) + "\n";
    }

}