import java.util.ArrayList;
import java.util.List;

public class Store {
    private String storeName;
    private List<Product> inventory;

    public Store(String storeName) {
        this.storeName = storeName;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return storeName;
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void displayProducts() {
        System.out.println("\n=== Available Products in " + storeName + " ===");
        System.out.printf("%-5s %-15s %-10s %-10s\n", "ID", "Name", "Price($)", "Stock");
        System.out.println("----------------------------------------------");
        for (Product product : inventory) {
            System.out.printf("%-5d %-15s %-10.2f %-10d\n", product.getId(), product.getName(), product.getPrice(), product.getStockQuantity());
        }
        System.out.println("----------------------------------------------");
    }

    public Product getProductById(int id) {
        for (Product product : inventory) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null; // Return null if not found
    }
}
