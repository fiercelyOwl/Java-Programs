import java.util.*;

public class BarangayManager {
    private Map<Integer, Barangay> barangays;
    private List<Barangay> barangayList;

    public BarangayManager() {
        this.barangays = new HashMap<>();
        this.barangayList = new ArrayList<>();
        initializeBarangays();
    }

    private void initializeBarangays() {
       
        addBarangay("Arkong Bato", 14.6850, 120.9700, "Eastern part of Valenzuela");
        addBarangay("Bagbaguin", 14.6920, 120.9750, "Northeast area");
        addBarangay("Balangkas", 14.7050, 120.9550, "North central area");
        addBarangay("Bignay", 14.6980, 120.9450, "North area");
        addBarangay("Bisig", 14.7150, 120.9650, "Northern tip");
        addBarangay("Canumay East", 14.6750, 120.9500, "West central area");
        addBarangay("Canumay West", 14.6700, 120.9450, "Western area");
        addBarangay("Coloong", 14.6920, 120.9350, "Southwest area");
        addBarangay("Dalandanan", 14.7050, 120.9400, "Central area");
        addBarangay("Gen. T. de Leon", 14.7016, 120.9475, "Central area");
        addBarangay("Isla", 14.6850, 120.9400, "Central area");
        addBarangay("Karuhatan", 14.7100, 120.9700, "Northeast area");
        addBarangay("Lawang Bato", 14.7000, 120.9800, "East area");
        addBarangay("Lingunan", 14.6650, 120.9500, "Southwest area");
        addBarangay("Mabolo", 14.6900, 120.9650, "East central area");
        addBarangay("Malanday", 14.7200, 120.9500, "North central area");
        addBarangay("Malinta", 14.7150, 120.9400, "North central area");
        addBarangay("Mapulang Lupa", 14.7080, 120.9250, "Northwest area");
        addBarangay("Marulas", 14.7000, 120.9300, "West central area");
        addBarangay("Maysan", 14.6950, 120.9550, "Central area");
        addBarangay("Palasan", 14.6800, 120.9600, "East area");
        addBarangay("Parada", 14.6950, 120.9650, "East central area");
        addBarangay("Pariancillo Villa", 14.7100, 120.9800, "Northeast corner");
        addBarangay("Paso de Blas", 14.7000, 120.9900, "East area");
        addBarangay("Pasolo", 14.6750, 120.9700, "East area");
        addBarangay("Poblacion", 14.6900, 120.9550, "Central/downtown area");
        addBarangay("Polo", 14.6850, 120.9500, "Central area");
        addBarangay("Punturin", 14.7050, 120.9300, "West central area");
        addBarangay("Rincon", 14.6900, 120.9400, "Central area");
        addBarangay("Tagalag", 14.7200, 120.9650, "North east area");
        addBarangay("Ugong", 14.6950, 120.9250, "West area");
        addBarangay("Veinte Reales", 14.7100, 120.9350, "North west area");
        addBarangay("Wawang Pulo", 14.7250, 120.9550, "Northern area");
    }

    private void addBarangay(String name, double latitude, double longitude, String description) {
        Location location = new Location(latitude, longitude);
        Barangay barangay = new Barangay(name, location, description);
        barangayList.add(barangay);
        barangays.put(barangayList.size(), barangay);
    }

    public List<Barangay> getAllBarangays() {
        return new ArrayList<>(barangayList);
    }
    

    public Barangay getBarangayByIndex(int index) {
        return barangays.getOrDefault(index, null);
    }

    public Barangay getBarangayByName(String name) {
        //check if name is null or empty
        if (name == null || name.trim().isEmpty()) {
            return null;
        }
        
        // Search for barangay with matching name
        for (Barangay barangay : barangayList) {
            if (barangay. getName().equalsIgnoreCase(name. trim())) {
                return barangay;
            }
        }
        
        return null;
    }

    public int getTotalBarangays() {
        return barangayList.size();
    }

    public void displayBarangayMenu() {
        System.out.println("\n=========================================");
        System.out. println("|      VALENZUELA CITY BARANGAYS         |");
        System.out.println("|         (Select Your Location)         |");
        System.out.println("===========================================\n");
        
        // display barangays in columns for better readability
        int index = 1;
        for (Barangay barangay : barangayList) {
            System.out.printf("%2d. %-25s\n", index, barangay.getName());
            index++;
        }
        
        System.out.println("\n=====================================");
    }

    public List<Barangay> searchBarangay(String partialName) {
        List<Barangay> results = new ArrayList<>();
        
        //check if partial name is null or empty
        if (partialName == null || partialName.trim().isEmpty()) {
            return results;
        }
        
        String searchTerm = partialName.trim(). toLowerCase();
        
        // Search for barangays containing the search term
        for (Barangay barangay : barangayList) {
            if (barangay.getName().toLowerCase().contains(searchTerm)) {
                results. add(barangay);
            }
        }
        
        return results;
    }
}