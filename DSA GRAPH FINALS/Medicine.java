
public class Medicine {
    private String name;
    private String dosage; 
    private double price;
    private int availableQuantity;
    private String manufacturer;
    private String expiryDate; 

    public Medicine(String name, String dosage, double price, 
                    int availableQuantity, String manufacturer, String expiryDate) {
        this.name = name;
        this.dosage = dosage;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.manufacturer = manufacturer;
        this.expiryDate = expiryDate;
    }

    public boolean reduceQuantity(int quantity) {
        //check if quantity is valid
        if (quantity <= 0) {
            System. out.println("Error: Quantity must be greater than 0");
            return false;
        }
        
        //check if sufficient stock available
        if (quantity > availableQuantity) {
            System.out.println("Error: Insufficient stock.   Available: " + availableQuantity);
            return false;
        }
        
        this.availableQuantity -= quantity;
        return true;
    }
    

    public String getName() {
        return name;
    }
    
    public String getDosage() {
        return dosage;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getAvailableQuantity() {
        return availableQuantity;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public String getExpiryDate() {
        return expiryDate;
    }

    public String getFullDescription() {
        return name + " " + dosage;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "name='" + name + '\'' +
                ", dosage='" + dosage + '\'' +
                ", price=" + price +
                ", quantity=" + availableQuantity +
                '}';
    }
}