import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Setup Supermarket (Store) and populate with Products
        Store store = new Store("Super Java Market");
        store.addProduct(new Product(1, "Milk", 1.50, 20));
        store.addProduct(new Product(2, "Bread", 2.00, 15));
        store.addProduct(new Product(3, "Eggs", 3.20, 30));
        store.addProduct(new Product(4, "Apple", 0.99, 50));
        store.addProduct(new Product(5, "Coffee", 5.50, 10));

        System.out.println("👋 Welcome to " + store.getName() + "!");
        System.out.print("Please enter your name: ");
        String customerName = scanner.nextLine();
        
        // Setup Customer
        Customer customer = new Customer(customerName);
        System.out.println("\nHello, " + customer.getName() + "! Let's start shopping.");

        boolean isShopping = true;

        // Command Loop
        while (isShopping) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. View Available Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("👉 Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    store.displayProducts();
                    break;

                case 2:
                    store.displayProducts();
                    System.out.print("Enter Product ID to add: ");
                    try {
                        int productId = Integer.parseInt(scanner.nextLine());
                        Product product = store.getProductById(productId);
                        
                        if (product != null) {
                            System.out.print("Enter Quantity: ");
                            int quantity = Integer.parseInt(scanner.nextLine());
                            
                            if (quantity > 0) {
                                customer.getCart().addItem(product, quantity);
                            } else {
                                System.out.println("❌ Quantity must be greater than 0.");
                            }
                        } else {
                            System.out.println("❌ Product not found! Invalid ID.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid input! Please enter valid numbers.");
                    }
                    break;

                case 3:
                    customer.getCart().displayCart();
                    break;

                case 4:
                    System.out.println("\n🛍️ Proceeding to checkout...");
                    customer.getCart().displayCart();
                    
                    if (customer.getCart().calculateTotal() > 0) {
                        System.out.println("✅ Payment successful. Thank you for shopping with us, " + customer.getName() + "!");
                        customer.getCart().clear();
                        isShopping = false;
                    } else {
                        System.out.println("❌ Your cart is empty. Please add items before checkout.");
                    }
                    break;

                case 5:
                    System.out.println("👋 Goodbye, " + customer.getName() + "! See you next time.");
                    isShopping = false;
                    break;

                default:
                    System.out.println("❌ Invalid option. Please choose between 1 and 5.");
            }
        }

        scanner.close();
    }
}
