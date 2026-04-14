
public class PurchaseItem {
    private String medicineName;
    private String dosage;
    private int quantity;
    private double unitPrice;
    
    public PurchaseItem(String medicineName, String dosage, int quantity, double unitPrice) {
        this.medicineName = medicineName;
        this. dosage = dosage;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    
    public String getMedicineName() { return medicineName; }
    public String getDosage() { return dosage; }
    public int getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }
    
    public double getTotalPrice() {
        return quantity * unitPrice;
    }
}