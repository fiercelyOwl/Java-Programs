import java.util.*;

public class Graph {
    private Map<String, Drugstore> drugstores;
    private Map<String, List<Edge>> adjacencyList;
    
    public Graph() {
        this.drugstores = new HashMap<>();
        this.adjacencyList = new HashMap<>();
    }
    
    public void addDrugstore(Drugstore drugstore) {
        if (drugstore == null) {
            System.out.println("Error: Drugstore cannot be null");
            return;
        }
        drugstores. put(drugstore.getId(), drugstore);
        adjacencyList.put(drugstore. getId(), new ArrayList<>());
    }
    
    public void addEdge(String source, String destination, double distance) {
        if (! drugstores.containsKey(source) || !drugstores.containsKey(destination)) {
            System.out.println("Error: One or both drugstores do not exist");
            return;
        }
        if (source.equals(destination)) {
            System.out.println("Error: Cannot create edge to the same drugstore");
            return;
        }
        adjacencyList.get(source).add(new Edge(destination, distance));
    }
    
    public Drugstore getDrugstore(String id) {
        return drugstores.getOrDefault(id, null);
    }
    
    public Map<String, Drugstore> getAllDrugstores() {
        return new HashMap<>(drugstores);
    }
    
    public List<Edge> getEdges(String drugstoreId) {
        return adjacencyList.getOrDefault(drugstoreId, new ArrayList<>());
    }
    
    public DrugstoreResult findBestDrugstoreForMedicine(
            Location customerLocation,
            String medicineName) {
        
        DrugstoreResult bestResult = null;
        double closestDistance = Double.MAX_VALUE;
        
        for (Drugstore store : drugstores.values()) {
            if (store.hasMedicine(medicineName)) {
                double distance = customerLocation.calculateDistance(store.getLocation());
                
                if (distance < closestDistance) {
                    closestDistance = distance;
                    Medicine medicine = store.getMedicine(medicineName);
                    
                    bestResult = new DrugstoreResult(
                        store.getName(),
                        distance,
                        medicine.getPrice(),
                        store.getAddress(),
                        medicine.getAvailableQuantity()
                    );
                }
            }
        }
        
        return bestResult;
    }
    
    public Map<String, DrugstoreResult> findBestDrugstoresForEachMedicine(
            Location customerLocation,
            List<String> medicinesRequired) {
        
        if (medicinesRequired == null || medicinesRequired.isEmpty()) {
            System.out.println("Error: Medicine list cannot be empty");
            return new HashMap<>();
        }
        
        Map<String, DrugstoreResult> bestResults = new LinkedHashMap<>();
        
        for (String medicine : medicinesRequired) {
            DrugstoreResult best = findBestDrugstoreForMedicine(customerLocation, medicine);
            if (best != null) {
                bestResults. put(medicine, best);
            }
        }
        
        return bestResults;
    }
    
    public List<DrugstoreResult> findTopDrugstoresForMedicine(
            Location customerLocation,
            String medicineName,
            int topN) {
        
        List<DrugstoreResult> results = new ArrayList<>();
        
        // double check
        if (medicineName == null || medicineName.trim().isEmpty()) {
            System.out.println("Warning: Medicine name is empty");
            return results;
        }
        
        // search for the medicine in all drugstores
        for (Drugstore store : drugstores.values()) {
            try {
                // check if store has this medicine 
                boolean hasMedicine = false;
                Medicine medicine = null;
                
                // try exact match first
                medicine = store.getMedicine(medicineName);
                
                // if not found, try case-insensitive search
                if (medicine == null) {
                    for (Medicine m : store.getInventory().values()) {
                        if (m.getName().equalsIgnoreCase(medicineName)) {
                            medicine = m;
                            hasMedicine = true;
                            break;
                        }
                    }
                } else {
                    hasMedicine = true;
                }
                
                if (hasMedicine && medicine != null && medicine.getAvailableQuantity() > 0) {
                    double distance = customerLocation.calculateDistance(store.getLocation());
                    
                    DrugstoreResult result = new DrugstoreResult(
                        store.getName(),
                        distance,
                        medicine.getPrice(),
                        store.getAddress(),
                        medicine.getAvailableQuantity()
                    );
                    
                    results.add(result);
                    System.out.println("Found: " + medicineName + " at " + store.getName());
                }
            } catch (Exception e) {
                System. out.println("Error checking store " + store.getName() + ": " + e.getMessage());
            }
        }
        
        // sort by distance
        results.sort(Comparator.comparingDouble(DrugstoreResult::getDistance));
        
        // return top N
        return results.subList(0, Math.min(topN, results.size()));
    }
    
    public double calculateTotalCost(Map<String, DrugstoreResult> bestMedicinesMap) {
        double totalCost = 0.0;
        for (DrugstoreResult result : bestMedicinesMap.values()) {
            totalCost += result.getPrice();
        }
        return totalCost;
    }
    
    public double calculateTotalDistance(Map<String, DrugstoreResult> bestMedicinesMap) {
        double totalDistance = 0.0;
        for (DrugstoreResult result : bestMedicinesMap.values()) {
            totalDistance += result.getDistance();
        }
        return totalDistance;
    }
    
    public double calculateAverageDistance(Map<String, DrugstoreResult> bestMedicinesMap) {
        if (bestMedicinesMap.isEmpty()) {
            return 0;
        }
        double totalDistance = calculateTotalDistance(bestMedicinesMap);
        return totalDistance / bestMedicinesMap.size();
    }

    public static class Edge {
        private String destination;
        private double distance;
        
        public Edge(String destination, double distance) {
            this.destination = destination;
            this.distance = distance;
        }
        
        public String getDestination() {
            return destination;
        }
        
        public double getDistance() {
            return distance;
        }
    }
}