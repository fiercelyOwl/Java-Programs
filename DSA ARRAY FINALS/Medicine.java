
public class Medicine {
    private String name;
    private String dosage;
    private String location;
    private double price;
    private int quantity;
    

    public Medicine(String name, String dosage, String location, double price, int quantity) {
        this.name = name;
        this.dosage = dosage;
        this. location = location;
        this. price = price;
        this. quantity = quantity;
    }
    

    public String getName() { return name; }
    public String getDosage() { return dosage; }
    public String getLocation() { return location; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    

    public boolean addStock(int amount) {
        if (amount <= 0) {
            return false;
        }
        this.quantity += amount;
        return true;
    }

    public boolean reduceQuantity(int amount) {
        if (amount > this.quantity || amount <= 0) {
            return false;
        }
        this. quantity -= amount;
        return true;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s - Location: %s | Price: ₱%.2f | Available: %d",
                name, dosage, location, price, quantity);
    }

    public String getDetailedInfo() {
        return String. format("Name: %s\nDosage: %s\nLocation: %s\nAvailable: %d units",
                name, dosage, location, quantity);
    }
}