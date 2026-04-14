
public class Barangay {
    private String name;
    private Location centerLocation; // Center point of the barangay
    private String description;

    public Barangay(String name, Location centerLocation, String description) {
        this.name = name;
        this.centerLocation = centerLocation;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    
    public Location getCenterLocation() {
        return centerLocation;
    }
    
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }
}