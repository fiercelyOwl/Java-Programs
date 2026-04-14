
public class Customer {
    private String customerName;
    private String contactNumber;
    private PurchaseItem[] items;
    private int itemCount;
    private static final int INITIAL_ITEMS_CAPACITY = 20;
    
    public Customer(String customerName, String contactNumber) {
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.items = new PurchaseItem[INITIAL_ITEMS_CAPACITY];
        this.itemCount = 0;
    }
    
    public String getCustomerName() { return customerName; }
    public String getContactNumber() { return contactNumber; }
    public int getItemCount() { return itemCount; }
    
    public boolean addItem(PurchaseItem item) {
        if (itemCount >= items.length) {
            return false;
        }
        items[itemCount] = item;
        itemCount++;
        return true;
    }
    
    public PurchaseItem getItem(int index) {
        if (index < 0 || index >= itemCount) {
            return null;
        }
        return items[index];
    }
    
    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getTotalPrice();
        }
        return total;
    }
}