package Entity;

public class Earning {
    private String id;
    private double amount;

    public Earning(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    
    
    public String toString() {
        return "Earning ID: " + id + " Amount: " + amount;
    }
}
