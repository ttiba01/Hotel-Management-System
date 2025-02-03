package Entity;

public class Food {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Food(String id, String name, double price, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;package Entity;

// Abstraction: Interface for food items
interface FoodItem {
    String getFoodAsString();
}

public class Food implements FoodItem { // Implementing Abstraction
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Food(String id, String name, double price, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    // Encapsulation: Getters and Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Implementing the abstract method from FoodItem
    public String getFoodAsString() {
        return "ID: " + id + "\nName: " + name + "\nCategory: " + category + "\nPrice: " + price + "\nQuantity: " + quantity;
    }
}

// Inheritance: Creating a subclass that extends Food
class SpecialFood extends Food {
    private String specialOffer;

    public SpecialFood(String id, String name, double price, int quantity, String category, String specialOffer) {
        super(id, name, price, quantity, category); // Calling the parent class constructor
        this.specialOffer = specialOffer;
    }

    public String getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(String specialOffer) {
        this.specialOffer = specialOffer;
    }

    // Overriding getFoodAsString (Polymorphism)
   
    public String getFoodAsString() {
        return super.getFoodAsString() + "\nSpecial Offer: " + specialOffer;
    }
}

    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFoodAsString() {
        return "ID: " + id + "\nName: " + name + "\nCategory: " + category + "\nPrice: " + price + "\nQuantity: " + quantity;
    }
}
