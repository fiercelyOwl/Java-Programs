
public class DrugstoreResult {
    private String storeName;
    private double distance; 
    private double price;
    private String address;
    private int availableQuantity;

    public DrugstoreResult(String storeName, double distance, double price, 
                           String address, int availableQuantity) {
        this.storeName = storeName;
        this. distance = distance;
        this. price = price;
        this. address = address;
        this. availableQuantity = availableQuantity;
    }
    

    public String getStoreName() {
        return storeName;
    }
    
    public double getDistance() {
        return distance;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getAddress() {
        return address;
    }
    
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    @Override
    public String toString() {
        return "Store: " + storeName +
               " | Distance: " + distance + " km" +
               " | Price: ₱" + price +
               " | Available: " + availableQuantity;
    }
}