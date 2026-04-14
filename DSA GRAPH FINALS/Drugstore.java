import java.util.*;

public class Drugstore {
    private String id;
    private String name;
    private String address;
    private Location location;
    private String companyName;

    private Map<String, Medicine> medicineInventory;
    private String phoneNumber;
    private String operatingHours;

    public Drugstore(String id, String name, String address, Location location, 
                     String companyName, String phoneNumber, String operatingHours) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.location = location;
        this.companyName = companyName;
        this. phoneNumber = phoneNumber;
        this.operatingHours = operatingHours;
        this.medicineInventory = new HashMap<>();
    }

    public void addMedicine(Medicine medicine) {
        //check if medicine is null
        if (medicine == null) {
            System.out.println("Error: Medicine cannot be null");
            return;
        }
        
        medicineInventory. put(medicine.getName(). toLowerCase(), medicine);
    }

    public boolean hasMedicine(String medicineName) {
        //check if medicine name is empty or null
        if (medicineName == null || medicineName.trim().isEmpty()) {
            System. out.println("Error: Medicine name cannot be empty");
            return false;
        }
        
        Medicine medicine = medicineInventory.get(medicineName.toLowerCase());
        return medicine != null && medicine. getAvailableQuantity() > 0;
    }

    public Medicine getMedicine(String medicineName) {
        return medicineInventory.get(medicineName.toLowerCase());
    }

    public Map<String, Medicine> getInventory() {
        return new HashMap<>(medicineInventory);
    }
    

    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public String getCompanyName() {
        return companyName;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getOperatingHours() {
        return operatingHours;
    }

    @Override
    public String toString() {
        return "Drugstore{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", location=" + location +
                ", companyName='" + companyName + '\'' +
                ", medicinesCount=" + medicineInventory.size() +
                '}';
    }
}