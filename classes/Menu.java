import java.util.HashMap;

public class Menu {

    private HashMap<String, Food> menu;

    public Menu() {
        this.menu = createMenu();
    }

    private HashMap<String, Food> createMenu() {
        Food hamburger = new Food("Hamburger", 600.0, new String[]{"Buns", "Patty", "Tomatoes", "Lettuce", "Cheese", "Onions", "Pickles", "Burger sauce"}, 8.00);
        Food sandwich = new Food("Sandwich", 500.0, new String[]{"White Bread", "Butter", "Ham", "Cheese", "Lettuce", "Tomatoes"}, 5.50);
        Food fries = new Food("Fries", 400.0, new String[]{"Potato", "Salt", "Olive oil", "Black pepper", "Thyme"}, 3.50);
        Food chickenWings = new Food("Chicken Wings", 700.0, new String[]{"Chicken wings", "Buffalo sauce", "Butter", "Honey"}, 8.50);
        Food coke = new Food("Coke", 300.0, new String[]{"Water", "Fructose corn syrup", "Caramel color"}, 2.00);
        Food iceTea = new Food("Ice Tea", 200.0, new String[]{"Water", "Sugar", "Tea concentrate"}, 2.00);

        HashMap<String, Food> menu = new HashMap<>();
        menu.put("Hamburger", hamburger);
        menu.put("Sandwich", sandwich);
        menu.put("Fries", fries);
        menu.put("Chicken Wings", chickenWings);
        menu.put("Coke", coke);
        menu.put("Ice Tea", iceTea);

        return menu;
    }

    public HashMap<String, Food> getMenu() {
        return this.menu;
    }

    public void printMenu() {
        for (Food f : this.menu.values()) { // for each food f in menu
            System.out.println(f.toString());
        }
    }
}