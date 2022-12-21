public class Cashier extends Person {

    private double id;
    
    public Cashier(String name, double id) {
        super(name);
        this.id = id;
    }

    public double getId() {
        return id;
    }

}