import javax.swing. JOptionPane;

public class CustomerSystem {
    private MedicineDatabase database;
    
    public CustomerSystem(MedicineDatabase database) {
        this. database = database;
    }

    public void startCustomerPanel() {
        boolean running = true;
        
        while (running) {
            String[] options = {"Locate Medicine", "Make a Purchase", "View All Medicines", "View Category", "Exit"};
            
            int choice = JOptionPane. showOptionDialog(
                null,
                "========== CUSTOMER MENU ==========\nSelect an option:",
                "Customer Panel",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
            );
            
            switch (choice) {
                case 0:
                    customerLocateMedicine();
                    break;
                case 1:
                    makePurchase();
                    break;
                case 2:
                    viewAllMedicines();
                    break;
                case 3:
                    viewCategoryMenu();
                    break;
                case 4:
                case -1:
                    running = false;
                    JOptionPane.showMessageDialog(null, "Thank you for shopping!  Goodbye!", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERROR: Invalid choice!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void customerLocateMedicine() {
        try {
            String medicineName = JOptionPane.showInputDialog(
                null,
                "Enter medicine name:",
                "Locate Medicine",
                JOptionPane. QUESTION_MESSAGE
            );
            
            if (medicineName == null) return;
            if (medicineName.trim().isEmpty()) {
                JOptionPane. showMessageDialog(null, "ERROR: Medicine name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String dosage = JOptionPane.showInputDialog(
                null,
                "Enter dosage (e.g., 250mg):",
                "Locate Medicine",
                JOptionPane.QUESTION_MESSAGE
            );
            
            if (dosage == null) return;
            if (dosage.trim().isEmpty()) {
                JOptionPane. showMessageDialog(null, "ERROR: Dosage cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String locationInfo = database.locateMedicine(medicineName, dosage);
            JOptionPane.showMessageDialog(
                null,
                locationInfo,
                "Medicine Location",
                JOptionPane. INFORMATION_MESSAGE
            );
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: An error occurred: " + e. getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private void makePurchase() {
        try {

            String customerName = JOptionPane.showInputDialog(
                null,
                "Enter your name:",
                "Customer Information",
                JOptionPane. QUESTION_MESSAGE
            );
            
            if (customerName == null) return;
            if (customerName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: Name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String contactNumber = JOptionPane.showInputDialog(
                null,
                "Enter your contact number:",
                "Customer Information",
                JOptionPane.QUESTION_MESSAGE
            );
            
            if (contactNumber == null) return;
            if (contactNumber.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: Contact number cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Customer customer = new Customer(customerName, contactNumber);

            addItemsToCustomerCart(customer);

            if (customer. getItemCount() == 0) {
                JOptionPane.showMessageDialog(null, "No items added.  Purchase cancelled.", "Cancelled", JOptionPane. INFORMATION_MESSAGE);
                return;
            }

            processPurchase(customer);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addItemsToCustomerCart(Customer customer) {
        boolean addingItems = true;
        int itemCount = 0;
        
        while (addingItems) {
            itemCount++;
            String medicineName = JOptionPane.showInputDialog(
                null,
                "Item #" + itemCount + "\nEnter medicine name (or click Cancel to finish):",
                "Add Item to Cart",
                JOptionPane.QUESTION_MESSAGE
            );
            
            if (medicineName == null) {
                addingItems = false;
                break;
            }
            
            if (medicineName.trim(). isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: Medicine name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                itemCount--;
                continue;
            }
            
            String dosage = JOptionPane.showInputDialog(
                null,
                "Enter dosage (e.g., 250mg):",
                "Add Item to Cart",
                JOptionPane.QUESTION_MESSAGE
            );
            
            if (dosage == null) {
                itemCount--;
                continue;
            }
            
            if (dosage.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: Dosage cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                itemCount--;
                continue;
            }

            Medicine medicine = database.searchMedicine(medicineName, dosage);
            if (medicine == null) {
                JOptionPane.showMessageDialog(null, "ERROR: Medicine not found in inventory!", "Error", JOptionPane. ERROR_MESSAGE);
                itemCount--;
                continue;
            }

            if (medicine.getQuantity() == 0) {
                JOptionPane.showMessageDialog(null, "ERROR: This medicine is currently out of stock!", "Error", JOptionPane.ERROR_MESSAGE);
                itemCount--;
                continue;
            }

            String quantityStr = JOptionPane.showInputDialog(
                null,
                "Enter quantity (Max available: " + medicine.getQuantity() + "):",
                "Add Item to Cart",
                JOptionPane.QUESTION_MESSAGE
            );
            
            if (quantityStr == null) {
                itemCount--;
                continue;
            }
            
            int quantity = getValidInteger(quantityStr);
            if (quantity < 0) {
                JOptionPane.showMessageDialog(null, "ERROR: Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                itemCount--;
                continue;
            }

            if (quantity > medicine.getQuantity()) {
                JOptionPane.showMessageDialog(null, "ERROR: Only " + medicine.getQuantity() + " units available!", "Error", JOptionPane.ERROR_MESSAGE);
                itemCount--;
                continue;
            }

            PurchaseItem item = new PurchaseItem(medicineName, dosage, quantity, medicine. getPrice());
            customer.addItem(item);
            JOptionPane.showMessageDialog(null, "SUCCESS: " + quantity + " x " + medicineName + " added to cart!", "Success", JOptionPane. INFORMATION_MESSAGE);
        }
    }
    

    private void processPurchase(Customer customer) {

        boolean purchaseSuccessful = true;
        for (int i = 0; i < customer.getItemCount(); i++) {
            PurchaseItem item = customer.getItem(i);
            Medicine medicine = database.searchMedicine(item.getMedicineName(), item.getDosage());
            
            if (medicine == null || ! medicine.reduceQuantity(item.getQuantity())) {
                purchaseSuccessful = false;
                break;
            }
        }
        
        if (! purchaseSuccessful) {
            JOptionPane.showMessageDialog(null, "ERROR: Purchase could not be completed.  Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        

        printReceipt(customer);
    }
    

    private void printReceipt(Customer customer) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("===========================================================================\n");
        receipt.append("                          *** RECEIPT ***\n");
        receipt.append("===========================================================================\n\n");
        

        receipt. append("Customer Name: ").append(customer.getCustomerName()).append("\n");
        receipt.append("Contact Number: ").append(customer.getContactNumber()).append("\n");
        receipt.append("Date & Time: ").append(java.time.LocalDateTime.now(). format(
                java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n\n");
        

        receipt.append("---------------------------------------------------------------------------\n");
        receipt. append(String.format("%-25s %-12s %-8s %-15s %-12s\n", "Medicine", "Dosage", "Qty", "Unit Price", "Total"));
        receipt. append("---------------------------------------------------------------------------\n");
        
        for (int i = 0; i < customer.getItemCount(); i++) {
            PurchaseItem item = customer.getItem(i);
            receipt.append(String.format("%-25s %-12s %-8d ₱%-14. 2f ₱%. 2f\n",
                    item.getMedicineName(),
                    item.getDosage(),
                    item.getQuantity(),
                    item.getUnitPrice(),
                    item. getTotalPrice()));
        }
        

        receipt.append("---------------------------------------------------------------------------\n");
        double totalAmount = customer.calculateTotal();
        receipt.append(String.format("%52s ₱%.2f\n", "TOTAL: ", totalAmount));
        receipt.append("===========================================================================\n");
        receipt.append("Thank you for your purchase!\n");
        receipt.append("===========================================================================\n");
        
        JOptionPane.showMessageDialog(null, receipt.toString(), "Receipt", JOptionPane. INFORMATION_MESSAGE);
    }

    private void viewAllMedicines() {
        String allMedicines = database.getAllMedicinesAsString();
        JOptionPane. showMessageDialog(null, allMedicines, "Complete Inventory", JOptionPane. INFORMATION_MESSAGE);
    }

    private void viewCategoryMenu() {
        String[] categories = {"Cough & Colds", "Vitamins", "Child Supplements", "Cancel"};
        
        int choice = JOptionPane.showOptionDialog(
            null,
            "Select a category to view:",
            "View Category",
            JOptionPane. DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            categories,
            categories[0]
        );
        
        switch (choice) {
            case 0:
                String coughColds = database.getCategoryAsString("cough");
                JOptionPane.showMessageDialog(null, coughColds, "Cough & Colds", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                String vitamins = database.getCategoryAsString("vitamins");
                JOptionPane. showMessageDialog(null, vitamins, "Vitamins", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                String childSupps = database.getCategoryAsString("child");
                JOptionPane. showMessageDialog(null, childSupps, "Child Supplements", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                break;
        }
    }

    private int getValidInteger(String input) {
        try {
            int value = Integer.parseInt(input. trim());
            if (value < 0) return -1;
            return value;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}