import java.util.*;

public class OptimizedSearchResult {
    private List<String> medicinesSearched;
    private Map<String, DrugstoreResult> bestDrugstoresPerMedicine;
    private double totalCost;
    private double totalDistance;
    private double averageDistance;

    public OptimizedSearchResult(List<String> medicinesSearched,
                                Map<String, DrugstoreResult> bestDrugstoresPerMedicine) {
        this.medicinesSearched = new ArrayList<>(medicinesSearched);
        this.bestDrugstoresPerMedicine = new LinkedHashMap<>(bestDrugstoresPerMedicine);
        calculateTotals();
    }

    private void calculateTotals() {
        this.totalCost = 0.0;
        this.totalDistance = 0.0;
        
        for (DrugstoreResult result : bestDrugstoresPerMedicine.values()) {
            totalCost += result.getPrice();
            totalDistance += result.getDistance();
        }
        
        this.averageDistance = bestDrugstoresPerMedicine.isEmpty() ?  
            0 : totalDistance / bestDrugstoresPerMedicine.size();
    }
    

    public List<String> getMedicinesSearched() {
        return new ArrayList<>(medicinesSearched);
    }
    
    public Map<String, DrugstoreResult> getBestDrugstoresPerMedicine() {
        return new LinkedHashMap<>(bestDrugstoresPerMedicine);
    }
    
    public double getTotalCost() {
        return totalCost;
    }
    
    public double getTotalDistance() {
        return totalDistance;
    }
    
    public double getAverageDistance() {
        return averageDistance;
    }
    
    public int getMedicineCount() {
        return medicinesSearched.size();
    }
    

    public int getUniqueDrugstoreCount() {
        Set<String> uniqueStores = new HashSet<>();
        
        for (DrugstoreResult result : bestDrugstoresPerMedicine.values()) {
            uniqueStores.add(result.getStoreName());
        }
        
        return uniqueStores.size();
    }

    public Set<String> getUniqueDrugstores() {
        Set<String> uniqueStores = new LinkedHashSet<>();
        
        for (DrugstoreResult result : bestDrugstoresPerMedicine.values()) {
            uniqueStores.add(result. getStoreName());
        }
        
        return uniqueStores;
    }

    public boolean allMedicinesFound() {
        return bestDrugstoresPerMedicine.size() == medicinesSearched.size();
    }

    public List<String> getMissingMedicines() {
        List<String> missing = new ArrayList<>();
        
        for (String medicine : medicinesSearched) {
            if (!bestDrugstoresPerMedicine.containsKey(medicine)) {
                missing.add(medicine);
            }
        }
        
        return missing;
    }
}