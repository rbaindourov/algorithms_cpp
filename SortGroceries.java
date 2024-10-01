import java.util.*;

// Grocery item class
class GroceryItem {
    String name;
    double price;
    double rating; // added field

    GroceryItem(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating; // added initialization
    }

    String getName() { return name; }
    double getPrice() { return price; }
    double getRating() { return rating; } // added getter

    @Override
    public String toString() {
        return name + ": $" + price + ", rating: " + rating;
    }
}

// Main class should be named 'Solution'.
class SortGroceries {
    public static void main(String[] args) {
        ArrayList<GroceryItem> inventory = new ArrayList<>(
                Arrays.asList(
                        new GroceryItem("Milk", 2.99, 4.5),
                        new GroceryItem("Bread", 2.99, 4.7),
                        new GroceryItem("Eggs", 3.49, 4.3)
                )
        );

        inventory.sort(Comparator
                .comparingDouble(GroceryItem::getPrice)
                .thenComparingDouble(GroceryItem::getRating).reversed() // higher rating first
        );

        System.out.println(inventory);
    }
}
