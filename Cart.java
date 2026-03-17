import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        if (product.getStockQuantity() >= quantity) {
            // Check if product is already in the cart
            boolean found = false;
            for (CartItem item : items) {
                if (item.getProduct().getId() == product.getId()) {
                    item.addQuantity(quantity);
                    found = true;
                    break;
                }
            }
            if (!found) {
                items.add(new CartItem(product, quantity));
            }
            // Reduce stock from supermarket
            product.setStockQuantity(product.getStockQuantity() - quantity);
            System.out.println("✅ " + quantity + " x " + product.getName() + " added to your cart.");
        } else {
            System.out.println("❌ Not enough stock for " + product.getName() + ". Available: " + product.getStockQuantity());
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("\n🛒 Your cart is empty.");
            return;
        }
        System.out.println("\n=== Your Shopping Cart ===");
        System.out.printf("%-15s %-10s %-10s\n", "Product", "Qty", "Subtotal");
        System.out.println("-----------------------------------");
        for (CartItem item : items) {
            System.out.printf("%-15s %-10d $%-10.2f\n", item.getProduct().getName(), item.getQuantity(), (item.getProduct().getPrice() * item.getQuantity()));
        }
        System.out.println("-----------------------------------");
        System.out.printf("Total Amount: $%.2f\n", calculateTotal());
        System.out.println("===================================");
    }
    
    public void clear() {
        items.clear();
    }
}
