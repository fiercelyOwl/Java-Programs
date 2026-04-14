import java.util.*;

public class ExerciseMaterialQueueSystem {
    private MaterialQueue materialQueue;
    private ExerciseDatabaseLoader exerciseDatabase;
    private List<Receipt> generatedReceipts;
    private Scanner scanner;

    public ExerciseMaterialQueueSystem() {
        this.materialQueue = new MaterialQueue();
        this.exerciseDatabase = new ExerciseDatabaseLoader();
        this.generatedReceipts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out. println("\n============================================================");
        System.out.println("|   EXERCISE MATERIALS QUEUE MANAGEMENT SYSTEM               |");
        System.out.println("==============================================================\n");

        boolean isRunning = true;
        while (isRunning) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice:  ", 1, 5);

            switch (choice) {
                case 1:
                    registerNewCustomer();
                    break;
                case 2:
                    processNextCustomer();
                    break;
                case 3:
                    viewQueueStatus();
                    break;
                case 4:
                    viewAvailableSicknesses();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("\nThank you for using the Exercise Materials Queue System.  Goodbye!\n");
                    break;
                default:
                    System.out.println("Invalid choice.  Please try again.");
            }
        }

        scanner.close();
    }

    /**
     * Display the main menu options
     */
    private void displayMainMenu() {
        System.out.println("\n┌────────────────────────────────────────────────────────────┐");
        System.out.println("│                    MAIN MENU                              │");
        System.out. println("├────────────────────────────────────────────────────────────┤");
        System.out.println("│ 1. Register New Customer                                   │");
        System.out. println("│ 2. Process Next Customer (Generate Receipt)               │");
        System.out. println("│ 3. View Queue Status                                       │");
        System.out.println("│ 4. View Available Sicknesses                               │");
        System.out. println("│ 5. Exit System                                             │");
        System.out.println("└────────────────────────────────────────────────────────────┘");
    }

    private void registerNewCustomer() {
        System.out.println("\n==========================================================");
        System.out.println("CUSTOMER REGISTRATION");
        System.out.println("============================================================\n");

        try {
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine().trim();
            if (customerName.isEmpty()) {
                System.out.println(" Error: Customer name cannot be empty.");
                return;
            }

            System.out.print("Enter contact number: ");
            String contactNumber = scanner.nextLine().trim();
            if (contactNumber.isEmpty()) {
                System.out. println(" Error: Contact number cannot be empty.");
                return;
            }

            System. out.println("\nAvailable health conditions:");
            Set<String> sicknesses = exerciseDatabase.getAllSicknessCategories();
            List<String> sicknessList = new ArrayList<>(sicknesses);
            Collections.sort(sicknessList);

            for (int i = 0; i < sicknessList.size(); i++) {
                System.out.println((i + 1) + ". " + sicknessList.get(i));
            }

            int sicknessChoice = getIntInput("\nSelect health condition (enter number): ", 1, sicknessList.size());
            String selectedSickness = sicknessList. get(sicknessChoice - 1);

            System.out. println("\nExercises for " + selectedSickness + ":");
            List<ExerciseMaterial> exercises = exerciseDatabase. getExercisesBySickness(selectedSickness);

            for (int i = 0; i < exercises.size(); i++) {
                System.out. println((i + 1) + ". " + exercises.get(i).getExerciseName());
            }

            int exerciseChoice = getIntInput("\nSelect exercise (enter number): ", 1, exercises.size());
            ExerciseMaterial selectedExercise = exercises.get(exerciseChoice - 1);

            Customer customer = new Customer(customerName, contactNumber, selectedSickness, selectedExercise. getExerciseName());
            Queue<Equipment> requiredEquipment = selectedExercise.getRequiredEquipment();

            if (requiredEquipment.isEmpty()) {
                System.out. println("\n✓ Exercise '" + selectedExercise.getExerciseName() + "' requires no equipment.");
            } else {
                System.out.println("\n✓ Adding equipment to queue for customer:  " + customer.getCustomerName());
                while (! requiredEquipment.isEmpty()) {
                    Equipment equipment = requiredEquipment.poll();
                    materialQueue.enqueueEquipment(customer, equipment);
                    System. out.println("  ➤ Queued: " + equipment.getEquipmentName());
                }
            }

            System.out. println("\n✓ Customer #" + customer.getCustomerNumber() + " registered successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println(" Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" An unexpected error occurred: " + e. getMessage());
        }
    }

    /**
     * Process the next customer in the queue and generate their receipt
     */
    private void processNextCustomer() {
        System.out.println("\n=========================================================");
        System.out.println("PROCESS NEXT CUSTOMER");
        System.out.println("===========================================================\n");

        if (materialQueue.isEmpty()) {
            System.out.println(" No customers in queue. Please register a customer first.");
            return;
        }

        try {
            Map<Customer, List<Equipment>> customerEquipment = new HashMap<>();

            while (!materialQueue.isEmpty()) {
                var nextItem = materialQueue.peekEquipment();
                if (nextItem == null) break;

                Customer currentCustomer = nextItem.getCustomer();
                var item = materialQueue.dequeueEquipment();
                customerEquipment.putIfAbsent(item.getCustomer(), new ArrayList<>());
                customerEquipment.get(item.getCustomer()).add(item. getEquipment());

                if (materialQueue.isEmpty() || 
                    (materialQueue.peekEquipment() != null && 
                     ! materialQueue.peekEquipment().getCustomer().equals(currentCustomer))) {
                    break;
                }
            }

            if (!customerEquipment. isEmpty()) {
                Customer processedCustomer = customerEquipment.keySet().iterator().next();
                List<Equipment> equipmentList = customerEquipment. get(processedCustomer);

                Receipt receipt = new Receipt(processedCustomer, equipmentList);
                generatedReceipts.add(receipt);
                receipt.printReceipt();
                System.out.println("\n Receipt generated and customer processed successfully!");
            }

        } catch (Exception e) {
            System.out.println(" Error processing customer:  " + e.getMessage());
        }
    }


    private void viewQueueStatus() {
        System.out.println("\n===========================================================");
        System.out.println("QUEUE STATUS");
        System.out.println("===========================================================");

        if (materialQueue.isEmpty()) {
            System.out. println("\n Queue is empty. All customers processed!");
        } else {
            System.out.println("\nTotal items in queue: " + materialQueue. getQueueSize());
            materialQueue.displayQueue();
        }
    }

    /**
     * Display all available sickness categories in the database
     */
    private void viewAvailableSicknesses() {
        System.out.println("\n===========================================================");
        System.out. println("AVAILABLE HEALTH CONDITIONS & EXERCISES");
        System.out.println("===========================================================\n");

        Set<String> sicknesses = exerciseDatabase. getAllSicknessCategories();
        List<String> sortedSicknesses = new ArrayList<>(sicknesses);
        Collections.sort(sortedSicknesses);

        for (String sickness : sortedSicknesses) {
            System.out. println(" " + sickness);
            List<ExerciseMaterial> exercises = exerciseDatabase.getExercisesBySickness(sickness);
            for (ExerciseMaterial exercise : exercises) {
                System.out.println(" >> " + exercise.getExerciseName());
            }
            System.out.println();
        }
    }

    private int getIntInput(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println(" Error: Please enter a valid number.");
                    continue;
                }
                int value = Integer.parseInt(input);
                if (value < min || value > max) {
                    System.out.println(" Error: Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        try {
            ExerciseMaterialQueueSystem system = new ExerciseMaterialQueueSystem();
            system.start();
        } catch (Exception e) {
            System.out.println(" Fatal Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}