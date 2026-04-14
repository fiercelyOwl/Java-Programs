import java.util.*;

public class Customer {
    private String name;
    private String contactNumber;
    private Location location;
    private List<String> searchedMedicines;

    public Customer(String name, String contactNumber, Location location) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.location = location;
        this.searchedMedicines = new ArrayList<>();
    }

    public boolean addSearchedMedicine(String medicineName) {
        //check if medicine name is empty
        if (medicineName == null || medicineName.trim().isEmpty()) {
            System.out. println("Error: Medicine name cannot be empty");
            return false;
        }
        
        String trimmedName = medicineName.trim();
        
        //prevent duplicate medicines
        if (searchedMedicines.contains(trimmedName)) {
            System.out.println("Error: " + trimmedName + " is already in your search list");
            return false;
        }
        
        searchedMedicines.add(trimmedName);
        return true;
    }

    public boolean removeSearchedMedicine(String medicineName) {
        //check if medicine name is empty
        if (medicineName == null || medicineName.trim().isEmpty()) {
            System.out. println("Error: Medicine name cannot be empty");
            return false;
        }
        
        return searchedMedicines.remove(medicineName.trim());
    }
    

    public List<String> getSearchedMedicines() {
        return new ArrayList<>(searchedMedicines);
    }

    public int getMedicineCount() {
        return searchedMedicines.size();
    }
    

    public boolean hasMedicine(String medicineName) {
        if (medicineName == null || medicineName.trim().isEmpty()) {
            return false;
        }
        return searchedMedicines.contains(medicineName.trim());
    }

    public void clearMedicines() {
        searchedMedicines.clear();
    }

    public void displayMedicines() {
        if (searchedMedicines.isEmpty()) {
            System. out.println("No medicines in search list");
            return;
        }
        
        System.out.println("Medicines in search list:");
        for (int i = 0; i < searchedMedicines.size(); i++) {
            System.out. println((i + 1) + ".  " + searchedMedicines. get(i));
        }
    }

    public String getName() {
        return name;
    }
    
    public String getContactNumber() {
        return contactNumber;
    }
    
    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", location=" + location +
                ", medicines=" + searchedMedicines. size() +
                '}';
    }
}