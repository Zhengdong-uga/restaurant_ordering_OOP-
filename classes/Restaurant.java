import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Restaurant {

    private String name;
    private Menu menu;
    private Cashier onDuty;
    private ArrayList<Customer> customers;
    private double revenue;

    public Restaurant(String name) {
        this.name = name;
        this.revenue = 0.0;
        this.menu = new Menu();
        this.customers = new ArrayList<>();
        this.createCashiers();
    }

    public void createCashiers() {
        Cashier amy = new Cashier("Amy", 1);
        Cashier sara = new Cashier("Sara", 2);
        Cashier katie = new Cashier("Katie", 3);
        Cashier karen = new Cashier("Karen", 4);
        int cashiernum = (int)(Math.random()*4);
        switch (cashiernum) {
            case 0:
                this.onDuty = amy;
                break;
            case 1:
                this.onDuty = sara;
                break;
            case 2:
                this.onDuty = katie;
                break;
            case 3:
                this.onDuty = karen;
                break;
            default:
                break;
        }
    }

    public String getName() {
        return this.name;
    }
    
    public Menu getMenu() {
        return this.menu;
    }

    public Cashier getCashier() {
        return this.onDuty;
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void addToRevenue(double money) {
        this.revenue += money;
    }

    public double getRevenue() {
        return revenue;
    }

    public static void run() {
        Scanner input = new Scanner(System.in);
        Restaurant restaurant = new Restaurant("Burger Haven");
        while (true) {
            restaurant.createCashiers();
            System.out.println("Welcome to " + restaurant.getName() + ", my name is " + restaurant.getCashier().getName() + ". Can I get a name for your order?");
            String name = input.nextLine();
            Customer customer = new Customer(name, 0);
            System.out.println("\nHello " + customer.getName() + "! Here are the menu options:");
            restaurant.getMenu().printMenu();
            restaurant.addCustomer(customer);

            boolean finished = false;
            ArrayList<String> totalOrder = new ArrayList<>();
            double total = 0;

            while (!finished) {
                System.out.println("What would you like to order?");
                String order = input.nextLine();
                if (!restaurant.getMenu().getMenu().keySet().contains(order)) {
                    System.out.println("Please give a correct order fromn our menu options!");
                    continue;
                } else {
                    totalOrder.add(order);
                    total += restaurant.getMenu().getMenu().get(order).getPrice();
                    System.out.println("Would that be all?");
                    String all = input.nextLine();
                    while (!all.equals("Yes")&&!all.equals("No")) {
                        System.out.println("Please Try Again");
                        all = input.nextLine();
                    }
                    if (all.equals("Yes")) {
                        break;
                    }
                }
            }
            restaurant.addToRevenue(total);
            System.out.println("You have ordered: ");
            for (String f : totalOrder) {
            System.out.println(f);
        }
            System.out.println("Your total is $" + total + "0\nHere is your receipt. Thank you " + customer.getName() + " for coming.");
            System.out.println("Are there any more customers?");
            String more = input.nextLine();
            while (!more.equals("Yes") && !more.equals("No")) {
                System.out.println("Try again: ");
                more = input.nextLine();
            }
            if (more.equals("No")) {
                break;
            }
        }
        input.close();
        System.out.println("There were a total of " + String.valueOf(restaurant.getCustomers().size()) + " customers!");
        System.out.println("You made $" + restaurant.getRevenue() + "0. Good job!");
    }
}