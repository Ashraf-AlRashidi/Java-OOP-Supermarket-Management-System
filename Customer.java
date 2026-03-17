public class Customer extends Person {
    private Cart cart;

    public Customer(String name) {
        super(name);
        this.cart = new Cart(); // Using Composition
    }

    public Cart getCart() {
        return cart;
    }

    @Override
    public void displayInfo() {
        System.out.println("Customer Profile - Name: " + name);
    }
}
