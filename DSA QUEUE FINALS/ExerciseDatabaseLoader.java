import java.util.*;

public class ExerciseDatabaseLoader {
    private Map<String, ExerciseMaterial> exerciseDatabase;

    public ExerciseDatabaseLoader() {
        exerciseDatabase = new HashMap<>();
        loadExerciseDatabase();
    }

    private void loadExerciseDatabase() {
        // Neck Pain Exercises
        addExercise("Neck Stretch", "Neck Pain", new String[]{"Yoga Mat"});
        addExercise("Shoulder Shrugs", "Neck Pain", new String[]{"Chair"});
        addExercise("Chin Tucks", "Neck Pain", new String[]{"Mirror"});

        // Shoulder Pain Exercises
        addExercise("Arm Raise", "Shoulder Pain", new String[]{"Yoga Mat"});
        addExercise("Shoulder Circles", "Shoulder Pain", new String[]{"Open Space"});
        addExercise("Shoulder Squeezes", "Shoulder Pain", new String[]{"Chair", "Pencil"});
        addExercise("Internal/External Rotation", "Shoulder Pain", new String[]{"Resistance Band", "Light Weight"});

        // Back Pain Exercises
        addExercise("Cat-Cow Stretch", "Back Pain", new String[]{"Yoga Mat"});
        addExercise("Lower Back Stretch", "Back Pain", new String[]{"Yoga Mat"});
        addExercise("Pelvic Tilt", "Back Pain", new String[]{"Yoga Mat"});
        addExercise("Supine Spinal Twist", "Back Pain", new String[]{"Yoga Mat"});

        // Leg Pain Exercises
        addExercise("Leg Stretch", "Leg Pain", new String[]{"Yoga Mat"});
        addExercise("Heel Raises", "Leg Pain", new String[]{"Chair"});
        addExercise("Quad Stretch", "Leg Pain", new String[]{"Chair", "Wall"});

        // Wrist / Hand Pain Exercises
        addExercise("Wrist Flex and Stretch", "Wrist / Hand Pain", new String[]{"Foam Roller"});
        addExercise("Fist Clench", "Wrist / Hand Pain", new String[]{"Stress Ball"});

        // Knee Pain Exercises
        addExercise("Knee Marching", "Knee Pain", new String[]{"Chair"});
        addExercise("Straight Leg Raise", "Knee Pain", new String[]{"Yoga Mat"});
        addExercise("Single-Leg Balance", "Knee Pain", new String[]{"Counter", "Wall"});
        addExercise("Standing Calf Stretch", "Knee Pain", new String[]{"Wall"});

        // Sciatica Exercises
        addExercise("Piriformis Stretch", "Sciatica", new String[]{"Yoga Mat"});
        addExercise("Knee-to-Chest Stretch", "Sciatica", new String[]{"Yoga Mat"});

        // Hand Arthritis Exercises
        addExercise("Finger Bends", "Hand Arthritis", new String[]{"Hand Therapy Ball"});
        addExercise("Thumb Stretch", "Hand Arthritis", new String[]{"Hand Therapy Ball"});

        // Hip Pain Exercises
        addExercise("Hip Flexor Stretch", "Hip Pain", new String[]{"Yoga Mat", "Cushion"});
        addExercise("Side Leg Raises", "Hip Pain", new String[]{"Yoga Mat"});
        addExercise("Knee to Chest Stretch", "Hip Pain", new String[]{"Yoga Mat"});
        addExercise("Bridge Exercise", "Hip Pain", new String[]{"Yoga Mat"});

        // Ankle Pain Exercises
        addExercise("Ankle Circles", "Ankle Pain", new String[]{"Chair"});
        addExercise("Toe Flex and Point", "Ankle Pain", new String[]{"Chair"});
        addExercise("Calf Stretch", "Ankle Pain", new String[]{"Wall"});

        // Foot Pain Exercises
        addExercise("Towel Stretch (Plantar Fascia)", "Foot Pain", new String[]{"Towel"});
        addExercise("Rolling Massage", "Foot Pain", new String[]{"Tennis Ball", "Frozen Water Bottle"});
        addExercise("Toe Spreading", "Foot Pain", new String[]{"Chair"});

        // Asthma / Difficulty Breathing Exercises
        addExercise("Pursed-Lip Breathing", "Asthma / Difficulty Breathing", new String[]{});
        addExercise("Diaphragmatic Breathing", "Asthma / Difficulty Breathing", new String[]{});

        // Hypertension Exercises
        addExercise("Slow Marching in Place", "Hypertension", new String[]{"Open Space"});
        addExercise("Wall Push-Ups", "Hypertension", new String[]{"Wall"});
        addExercise("Seated Knee Lifts", "Hypertension", new String[]{"Chair"});

        // Obesity / Overweight Exercises
        addExercise("Seated Leg Lifts", "Obesity / Overweight", new String[]{"Chair"});
        addExercise("Step Touch", "Obesity / Overweight", new String[]{"Open Space"});
        addExercise("Chair Squats", "Obesity / Overweight", new String[]{"Chair"});
        addExercise("Step Jack", "Obesity / Overweight", new String[]{"Open Space"});

        // Stroke Rehabilitation Exercises
        addExercise("Sitting Arm Lifts", "Stroke Rehabilitation", new String[]{"Chair"});
        addExercise("Ankle Pumps", "Stroke Rehabilitation", new String[]{"Chair", "Bed"});

        // Frozen Shoulder Exercises
        addExercise("Pendulum Stretch", "Frozen Shoulder", new String[]{"Table"});
        addExercise("Towel Stretch", "Frozen Shoulder", new String[]{"Towel"});
        addExercise("Finger Walk", "Frozen Shoulder", new String[]{"Wall"});

        // Ankle Sprain Exercises
        addExercise("Ankle Alphabet", "Ankle Sprain", new String[]{"Chair"});
        addExercise("Heel Raises (Ankle)", "Ankle Sprain", new String[]{"Wall", "Chair"});
        addExercise("Ankle Resistance Band Flex & Extend", "Ankle Sprain", new String[]{"Resistance Band"});

        // Rounded Upper Back Exercises
        addExercise("Seated Thoracic Stretch", "Rounded Upper Back", new String[]{"Chair"});
        addExercise("Wall Angels", "Rounded Upper Back", new String[]{"Wall"});
        addExercise("Chin Tucks (Posture)", "Rounded Upper Back", new String[]{"Mirror"});

        // Knee Osteoarthritis Exercises
        addExercise("Straight Leg Raise (Osteo)", "Knee Osteoarthritis", new String[]{"Yoga Mat"});
        addExercise("Seated Knee Extension", "Knee Osteoarthritis", new String[]{"Chair"});
        addExercise("Mini Squats", "Knee Osteoarthritis", new String[]{"Chair", "Table"});

        // Mild Scoliosis Exercises
        addExercise("Cat-Cow Stretch", "Mild Scoliosis", new String[]{"Yoga Mat"});
        addExercise("Side Plank", "Mild Scoliosis", new String[]{"Yoga Mat"});
        addExercise("Back Extension", "Mild Scoliosis", new String[]{"Yoga Mat"});

        // Migraine Exercises
        addExercise("Alternate Nostril Breathing", "Migraine", new String[]{});
        addExercise("Neck Stretch (Side Tilt)", "Migraine", new String[]{"Chair"});
        addExercise("Occipital/Trap Stretch", "Migraine", new String[]{"Chair"});
        addExercise("Corrugator Supercilia Release", "Migraine", new String[]{});

        // Thigh Pain Exercises
        addExercise("Quadriceps Set", "Thigh Pain", new String[]{"Yoga Mat"});
        addExercise("Supine Hamstring Stretch", "Thigh Pain", new String[]{"Towel", "Yoga Mat"});
        addExercise("Straight Leg Raise", "Thigh Pain", new String[]{"Yoga Mat"});
        addExercise("Side-Lying Hip Abduction", "Thigh Pain", new String[]{"Yoga Mat"});
    }

    private void addExercise(String exerciseName, String sickness, String[] equipmentNames) {
        ExerciseMaterial exercise = new ExerciseMaterial(exerciseName, sickness);
        Map<String, Double> equipmentPrices = getEquipmentPrices();

        for (String equipmentName : equipmentNames) {
            double price = equipmentPrices. getOrDefault(equipmentName, 19.99);
            Equipment equipment = new Equipment(equipmentName, price);
            exercise.addEquipment(equipment);
        }

        exerciseDatabase.put(exerciseName. toLowerCase(), exercise);
    }

    private Map<String, Double> getEquipmentPrices() {
        Map<String, Double> prices = new HashMap<>();
        prices.put("Yoga Mat", 29.99);
        prices.put("Chair", 89.99);
        prices.put("Mirror", 24.99);
        prices.put("Resistance Band", 12.99);
        prices.put("Light Weight", 15.99);
        prices.put("Wall", 0.00);
        prices.put("Open Space", 0.00);
        prices.put("Pencil", 1.99);
        prices.put("Foam Roller", 19.99);
        prices.put("Stress Ball", 8.99);
        prices.put("Counter", 0.00);
        prices.put("Hand Therapy Ball", 14.99);
        prices.put("Cushion", 22.99);
        prices.put("Tennis Ball", 5.99);
        prices.put("Frozen Water Bottle", 0.00);
        prices.put("Towel", 12.99);
        prices.put("Table", 0.00);
        prices.put("Bed", 0.00);
        return prices;
    }

    public ExerciseMaterial getExercise(String exerciseName) {
        if (exerciseName == null || exerciseName. trim().isEmpty()) {
            return null;
        }
        return exerciseDatabase.get(exerciseName.toLowerCase());
    }

    public Set<String> getAllSicknessCategories() {
        Set<String> sicknesses = new HashSet<>();
        for (ExerciseMaterial exercise :  exerciseDatabase.values()) {
            sicknesses.add(exercise.getSickness());
        }
        return sicknesses;
    }

    public List<ExerciseMaterial> getExercisesBySickness(String sickness) {
        List<ExerciseMaterial> exercises = new ArrayList<>();
        for (ExerciseMaterial exercise : exerciseDatabase.values()) {
            if (exercise.getSickness().equalsIgnoreCase(sickness)) {
                exercises.add(exercise);
            }
        }
        return exercises;
    }

    public boolean exerciseExists(String exerciseName) {
        return exerciseDatabase. containsKey(exerciseName. toLowerCase());
    }

    public Collection<ExerciseMaterial> getAllExercises() {
        return exerciseDatabase.values();
    }
}