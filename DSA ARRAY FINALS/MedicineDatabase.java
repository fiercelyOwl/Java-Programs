
public class MedicineDatabase {

    private Medicine[] coughColds = {
            new Medicine("Neozep", "250mg", "Aisle 1, Row 1", 7.50, 50),
            new Medicine("Bioflu", "500mg", "Aisle 1, Row 2", 8.50, 40),
            new Medicine("Decolgen", "250mg", "Aisle 1, Row 3", 8.75, 35),
            new Medicine("Paracetamol", "500mg", "Aisle 1, Row 4", 5.50, 100),
            new Medicine("Dextromethorphan", "15mg", "Aisle 1, Row 5", 14.75, 25)
    };

    private Medicine[] vitamins = {
            new Medicine("Poten-Cee", "500mg", "Aisle 2, Row 1", 6.25, 100),
            new Medicine("Poten-Cee", "1000mg", "Aisle 2, Row 2", 11.33, 80),
            new Medicine("Multivitamins", "1000mg", "Aisle 2, Row 3", 13.50, 60),
            new Medicine("Vitamin B Complex", "100mg", "Aisle 2, Row 4", 6.00, 45),
            new Medicine("Iron Supplement", "325mg", "Aisle 2, Row 5", 2.26, 30)
    };

    private Medicine[] childSupplements = {
            new Medicine("Ceelin", "60mL", "Aisle 3, Row 1", 73.00, 30),
            new Medicine("Pedzinc", "120mL", "Aisle 3, Row 2", 158.00, 20),
            new Medicine("Propan TLC Syrup", "60mL", "Aisle 3, Row 3", 140.00, 40),
            new Medicine("Ascorbic Acid for Kids", "120mL", "Aisle 3, Row 4", 100.00, 50),
            new Medicine("Lysine", "60mL", "Aisle 5, Row 5", 92.50, 25)
    };

    public Medicine searchMedicine(String name, String dosage) {
        Medicine found = searchInArray(coughColds, name, dosage);
        if (found != null) return found;
        
        found = searchInArray(vitamins, name, dosage);
        if (found != null) return found;
        
        found = searchInArray(childSupplements, name, dosage);
        if (found != null) return found;
        
        return null;
    }

    private Medicine searchInArray(Medicine[] array, String name, String dosage) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getName(). equalsIgnoreCase(name) &&
                array[i].getDosage().equalsIgnoreCase(dosage)) {
                return array[i];
            }
        }
        return null;
    }

    public String getCategoryAsString(String category) {
        Medicine[] selectedArray = null;
        String categoryName = "";
        
        if (category.equalsIgnoreCase("cough")) {
            selectedArray = coughColds;
            categoryName = "COUGH & COLDS";
        } else if (category.equalsIgnoreCase("vitamins")) {
            selectedArray = vitamins;
            categoryName = "VITAMINS";
        } else if (category.equalsIgnoreCase("child")) {
            selectedArray = childSupplements;
            categoryName = "CHILD SUPPLEMENTS";
        } else {
            return "ERROR: Invalid category! ";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("========== ").append(categoryName).append(" ==========\n");
        
        for (int i = 0; i < selectedArray.length; i++) {
            sb.append((i + 1)). append(". ").append(selectedArray[i].toString()).append("\n");
        }
        sb.append("=====================================");
        
        return sb.toString();
    }
    

    public String getAllMedicinesAsString() {
        StringBuilder sb = new StringBuilder();
        sb. append("========== COMPLETE MEDICINE INVENTORY ==========\n\n");
        sb.append(getCategoryAsString("cough")).append("\n\n");
        sb.append(getCategoryAsString("vitamins")). append("\n\n");
        sb.append(getCategoryAsString("child"));
        return sb.toString();
    }

    public String locateMedicine(String name, String dosage) {
        Medicine medicine = searchMedicine(name, dosage);
        
        if (medicine == null) {
            return "ERROR: Medicine not found in inventory!";
        }
        
        if (medicine.getQuantity() == 0) {
            return "Medicine " + name + " " + dosage + " is OUT OF STOCK!";
        }
        
        return String.format(" %s %s\nLocation: %s\nAvailable: %d units\nPrice: ₱%.2f",
                name, dosage, medicine. getLocation(), medicine.getQuantity(), medicine.getPrice());
    }
}