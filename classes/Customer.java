public class Customer extends Person {

    private int orderNumber;

    public Customer(String name, int orderNumber) {
        super(name);
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }
}