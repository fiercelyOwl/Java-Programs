
public class InputValidator {

    public static boolean isValidName(String name) {
        //check if name is null or empty
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Name cannot be empty");
            return false;
        }
        
        //name should only contain letters and spaces
        if (!name.matches("^[a-zA-Z ]+₱")) {
            System. out.println("Error: Name should only contain letters and spaces");
            return false;
        }
        
        //name length should be reasonable
        if (name.length() > 100) {
            System.out.println("Error: Name is too long (maximum 100 characters)");
            return false;
        }
        
        return true;
    }

    public static boolean isValidContactNumber(String contactNumber) {
        //check if contact number is null or empty
        if (contactNumber == null || contactNumber.trim().isEmpty()) {
            System.out.println("Error: Contact number cannot be empty");
            return false;
        }
        
        //contact number should contain only digits and hyphens
        if (!contactNumber.matches("^[0-9\\-+() ]+₱")) {
            System.out.println("Error: Invalid contact number format");
            return false;
        }
        
        //contact number should be at least 7 digits
        String digitsOnly = contactNumber.replaceAll("[^0-9]", "");
        if (digitsOnly. length() < 7) {
            System.out.println("Error: Contact number must contain at least 7 digits");
            return false;
        }
        
        return true;
    }

    public static boolean isValidCoordinates(double latitude, double longitude) {
        //latitude must be between -90 and 90
        if (latitude < -90 || latitude > 90) {
            System.out.println("Error: Latitude must be between -90 and 90");
            return false;
        }
        
        //longitude must be between -180 and 180
        if (longitude < -180 || longitude > 180) {
            System.out.println("Error: Longitude must be between -180 and 180");
            return false;
        }
        
        return true;
    }

    public static boolean isValidMedicineName(String medicineName) {
        //check if medicine name is null or empty
        if (medicineName == null || medicineName.trim().isEmpty()) {
            System.out. println("Error: Medicine name cannot be empty");
            return false;
        }
        
        //medicine name length should be reasonable
        if (medicineName.length() > 100) {
            System.out. println("Error: Medicine name is too long");
            return false;
        }
        
        return true;
    }

    public static boolean isValidPrice(double price) {
        //price cannot be negative
        if (price < 0) {
            System. out.println("Error: Price cannot be negative");
            return false;
        }
        
        return true;
    }

    public static boolean isValidQuantity(int quantity) {
        //quantity must be positive
        if (quantity <= 0) {
            System.out. println("Error: Quantity must be greater than 0");
            return false;
        }
        
        return true;
    }
}