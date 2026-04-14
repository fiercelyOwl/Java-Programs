import javax.swing. JOptionPane;


public class AdminSystem {
    private MedicineDatabase database;
    
    public AdminSystem(MedicineDatabase database) {
        this.database = database;
    }

    public void startAdminPanel() {
        boolean running = true;
        
        while (running) {

            String[] options = {"Add Stock", "Locate Medicine", "View All Medicines", "View Category", "Exit"};
            
            int choice = JOptionPane.showOptionDialog(
                null,
                "========== ADMIN MENU ==========\nSelect an option:",
                "Admin Panel",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
            );
            
            switch (choice) {
                case 0:
                    addStockToMedicine();
                    break;
                case 1:
                    adminLocateMedicine();
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
                    JOptionPane.showMessageDialog(null, "Exiting Admin Panel...", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERROR: Invalid choice!", "Error", JOptionPane. ERROR_MESSAGE);
            }
        }
    }

    private void addStockToMedicine() {
        try {

            String medicineName = JOptionPane.showInputDialog(
                null,
                "Enter medicine name:",
                "Add Stock",
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
                "Add Stock",
                JOptionPane.QUESTION_MESSAGE
            );
            
            if (dosage == null) return;
            if (dosage.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: Dosage cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Medicine medicine = database.searchMedicine(medicineName, dosage);
            if (medicine == null) {
                JOptionPane.showMessageDialog(null, "ERROR: Medicine not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(
                null,
                "--- Current Medicine Info ---\n\n" + medicine.getDetailedInfo(),
                "Medicine Info",
                JOptionPane. INFORMATION_MESSAGE
            );

            String quantityStr = JOptionPane.showInputDialog(
                null,
                "Enter quantity to add:",
                "Add Stock",
                JOptionPane.QUESTION_MESSAGE
            );
            
            if (quantityStr == null) return;

            int quantityToAdd = getValidInteger(quantityStr);
            if (quantityToAdd < 0) {
                JOptionPane.showMessageDialog(null, "ERROR: Please enter a valid number!", "Error", JOptionPane. ERROR_MESSAGE);
                return;
            }

            if (medicine.addStock(quantityToAdd)) {
                JOptionPane.showMessageDialog(
                    null,
                    "SUCCESS: Stock updated!\n\nNew quantity: " + medicine.getQuantity(),
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adminLocateMedicine() {
        try {
            String medicineName = JOptionPane. showInputDialog(
                null,
                "Enter medicine name:",
                "Locate Medicine",
                JOptionPane.QUESTION_MESSAGE
            );
            
            if (medicineName == null) return;
            if (medicineName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: Medicine name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String dosage = JOptionPane.showInputDialog(
                null,
                "Enter dosage (e. g., 250mg):",
                "Locate Medicine",
                JOptionPane.QUESTION_MESSAGE
            );
            
            if (dosage == null) return;
            if (dosage.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: Dosage cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane. showMessageDialog(null, "ERROR: An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewAllMedicines() {
        String allMedicines = database.getAllMedicinesAsString();
        JOptionPane. showMessageDialog(
            null,
            allMedicines,
            "Complete Inventory",
            JOptionPane. INFORMATION_MESSAGE
        );
    }

    private void viewCategoryMenu() {
        String[] categories = {"Cough & Colds", "Vitamins", "Child Supplements", "Cancel"};
        
        int choice = JOptionPane. showOptionDialog(
            null,
            "Select a category to view:",
            "View Category",
            JOptionPane.DEFAULT_OPTION,
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