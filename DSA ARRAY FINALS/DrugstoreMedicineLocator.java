import javax.swing. JOptionPane;

public class DrugstoreMedicineLocator {
    
    private static MedicineDatabase database;
    

    public static void main(String[] args) {

        database = new MedicineDatabase();
        

        displayWelcome();
        

        mainMenu();
    }

    private static void displayWelcome() {
        String welcome = "WELCOME TO DRUGSTORE MEDICINE LOCATOR SYSTEM\n\n" +
                        "Find your medicines quickly and easily!\n\n" +
                        "Categories Available:\n" +
                        "  • Cough & Colds\n" +
                        "  • Vitamins\n" +
                        "  • Child Supplements";
        
        JOptionPane. showMessageDialog(
            null,
            welcome,
            "Welcome! ",
            JOptionPane. INFORMATION_MESSAGE
        );
    }

    private static void mainMenu() {
        boolean running = true;
        
        while (running) {
            String[] options = {"Admin Panel", "Customer Panel", "Exit"};
            
            int choice = JOptionPane. showOptionDialog(
                null,
                "========== MAIN MENU ==========\nChoose your role:",
                "Drugstore Medicine Locator",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane. PLAIN_MESSAGE,
                null,
                options,
                options[0]
            );
            
            switch (choice) {
                case 0:
                    startAdminPanel();
                    break;
                case 1:
                    startCustomerPanel();
                    break;
                case 2:
                case -1:
                    running = false;
                    JOptionPane.showMessageDialog(
                        null,
                        "Thank you for using Drugstore Medicine Locator\n\nGoodbye!",
                        "Exit",
                        JOptionPane. INFORMATION_MESSAGE
                    );
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERROR: Invalid choice!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void startAdminPanel() {
        AdminSystem adminSystem = new AdminSystem(database);
        adminSystem.startAdminPanel();
    }

    private static void startCustomerPanel() {
        CustomerSystem customerSystem = new CustomerSystem(database);
        customerSystem.startCustomerPanel();
    }
}