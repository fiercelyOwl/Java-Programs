import java.util.*;


public class ExerciseMaterial {
    private String exerciseName;
    private String sickness; 
    private Queue<Equipment> requiredEquipment;


    public ExerciseMaterial(String exerciseName, String sickness) {
        if (exerciseName == null || exerciseName.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: Exercise name cannot be null or empty!");
        }
        if (sickness == null || sickness.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: Sickness cannot be null or empty!");
        }

        this.exerciseName = exerciseName;
        this.sickness = sickness;
        this.requiredEquipment = new LinkedList<>();
    }

    public void addEquipment(Equipment equipment) {
        if (equipment == null) {
            throw new IllegalArgumentException("Equipment cannot be null");
        }
        requiredEquipment.offer(equipment); 
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getSickness() {
        return sickness;
    }


    public Queue<Equipment> getRequiredEquipment() {
        return new LinkedList<>(requiredEquipment);
    }


    public double getTotalEquipmentCost() {
        double total = 0;
        for (Equipment equipment : requiredEquipment) {
            total += equipment.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return exerciseName + " (for:  " + sickness + ")";
    }
}