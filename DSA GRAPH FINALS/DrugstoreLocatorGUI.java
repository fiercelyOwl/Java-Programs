import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class DrugstoreLocatorGUI extends JFrame {
    private Graph graph;
    private BarangayManager barangayManager;
    private Customer currentCustomer;
    private OptimizedSearchResult optimizedResult;
    private Map<String, List<DrugstoreResult>> allMedicineOptions;

    private MapPanel mapPanel;
    private JComboBox<String> barangayCombo;
    private JTextField medicineField;
    private JButton searchButton;
    private JButton addMedicineButton;
    private JButton clearButton;
    private JList<String> medicineList;
    private DefaultListModel<String> medicineListModel;
    private JTable resultsTable;
    private JLabel statusLabel;
    private JPanel infoPanel;
    private JTextField nameField;
    private JTextField contactField;

    public DrugstoreLocatorGUI() {
        this.graph = new Graph();
        this. barangayManager = new BarangayManager();
        this.allMedicineOptions = new HashMap<>();
        
        setTitle("Drugstore Locator - Valenzuela City");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setResizable(true);
        
        initializeDrugstores();
        createGUI();
        
        setVisible(true);
    }

    private void initializeDrugstores() {
        Drugstore store1 = new Drugstore(
            "D001",
            "Mercury Drug - Gen.  T.  de Leon",
            "Gen. T. de Leon Avenue",
            new Location(14.7016, 120.9475),
            "Mercury Drug",
            "0917-123-4567",
            "8:00 AM - 10:00 PM"
        );
        store1.addMedicine(new Medicine("Paracetamol", "500mg", 45.00, 50, "Aspro", "2025-12-31"));
        store1.addMedicine(new Medicine("Amoxicillin", "500mg", 120.00, 30, "Generic", "2025-11-30"));
        store1.addMedicine(new Medicine("Salbutamol", "100mcg", 150.00, 15, "Inhaler", "2025-12-31"));
        store1. addMedicine(new Medicine("Metformin", "500mg", 98.00, 40, "Generic", "2025-12-31"));
        graph.addDrugstore(store1);

        Drugstore store2 = new Drugstore(
            "D002",
            "Watsons - Poblacion",
            "Poblacion",
            new Location(14.6900, 120.9550),
            "Watsons",
            "0917-234-5678",
            "8:30 AM - 9:30 PM"
        );
        store2.addMedicine(new Medicine("Amoxicillin", "500mg", 125.00, 45, "Generic", "2025-12-15"));
        store2.addMedicine(new Medicine("Cetirizine", "10mg", 95.00, 40, "Allertec", "2025-12-31"));
        store2.addMedicine(new Medicine("Paracetamol", "500mg", 48.00, 60, "Tylenol", "2025-12-31"));
        store2. addMedicine(new Medicine("Omeprazole", "20mg", 110.00, 35, "Generic", "2025-11-25"));
        graph.addDrugstore(store2);

        Drugstore store3 = new Drugstore(
            "D003",
            "Southstar Drug - Coloong",
            "Coloong Street",
            new Location(14.6920, 120.9350),
            "Southstar Drug",
            "0917-345-6789",
            "7:00 AM - 11:00 PM"
        );
        store3.addMedicine(new Medicine("Amoxicillin", "500mg", 118.00, 25, "Generic", "2025-12-20"));
        store3.addMedicine(new Medicine("Ibuprofen", "400mg", 52.00, 70, "Generic", "2025-10-31"));
        store3.addMedicine(new Medicine("Metformin", "500mg", 95.00, 45, "Generic", "2025-12-31"));
        store3.addMedicine(new Medicine("Paracetamol", "500mg", 42.00, 80, "Generic", "2025-10-31"));
        graph.addDrugstore(store3);

        Drugstore store4 = new Drugstore(
            "D004",
            "Lupang Arenda Pharmacy",
            "Canumay West",
            new Location(14.6750, 120.9450),
            "Local Pharmacy",
            "0917-456-7890",
            "8:00 AM - 8:00 PM"
        );
        store4.addMedicine(new Medicine("Amoxicillin", "500mg", 115.00, 35, "Generic", "2025-11-25"));
        store4.addMedicine(new Medicine("Aspirin", "500mg", 38.00, 55, "Generic", "2025-12-10"));
        store4.addMedicine(new Medicine("Dextromethorphan", "10mg", 75.00, 40, "Cough Relief", "2025-12-31"));
        store4.addMedicine(new Medicine("Paracetamol", "500mg", 40.00, 90, "Tempra", "2025-10-31"));
        graph.addDrugstore(store4);

        Drugstore store5 = new Drugstore(
            "D005",
            "Day-Night Pharmacy - Malanday",
            "Malanday",
            new Location(14.7200, 120.9500),
            "Day-Night Chain",
            "0917-567-8901",
            "24 Hours"
        );
        store5.addMedicine(new Medicine("Amoxicillin", "500mg", 122.00, 40, "Generic", "2025-12-25"));
        store5.addMedicine(new Medicine("Ranitidine", "150mg", 100.00, 30, "Generic", "2025-12-31"));
        store5.addMedicine(new Medicine("Ibuprofen", "400mg", 58.00, 65, "Alaxan", "2025-12-31"));
        store5. addMedicine(new Medicine("Paracetamol", "500mg", 46.00, 75, "Generic", "2025-10-31"));
        graph.addDrugstore(store5);

        Drugstore store6 = new Drugstore(
            "D006",
            "Good RX Pharmacy - Karuhatan",
            "Karuhatan",
            new Location(14.7100, 120.9700),
            "Good RX Chain",
            "0917-678-9012",
            "8:00 AM - 9:30 PM"
        );
        store6.addMedicine(new Medicine("Amoxicillin", "500mg", 120.00, 32, "Generic", "2025-12-15"));
        store6.addMedicine(new Medicine("Amlodipine", "5mg", 85.00, 28, "Generic", "2025-12-31"));
        store6.addMedicine(new Medicine("Paracetamol", "500mg", 44.00, 70, "Generic", "2025-10-31"));
        store6.addMedicine(new Medicine("Ibuprofen", "400mg", 54.00, 55, "Generic", "2025-12-31"));
        graph.addDrugstore(store6);
    }

    private void createGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory. createEmptyBorder(10, 10, 10, 10));

        JPanel leftPanel = new JPanel(new BorderLayout(10, 10));

        JPanel inputPanel = createInputPanel();
        leftPanel. add(inputPanel, BorderLayout. NORTH);

        JPanel resultsPanel = createResultsPanel();
        leftPanel.add(resultsPanel, BorderLayout.CENTER);

        mapPanel = new MapPanel(graph, barangayManager);
        JPanel mapPanelWithLabel = new JPanel(new BorderLayout());
        mapPanelWithLabel.add(new JLabel("Valenzuela City Map"), BorderLayout.NORTH);
        mapPanelWithLabel.add(mapPanel, BorderLayout.CENTER);

        statusLabel = new JLabel("Ready - Available medicines: Paracetamol, Amoxicillin, Ibuprofen, Aspirin, Metformin, Salbutamol, Cetirizine, Omeprazole, Dextromethorphan, Ranitidine, Amlodipine");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 9));
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusPanel.add(statusLabel);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, mapPanelWithLabel);
        splitPane.setDividerLocation(600);
        
        mainPanel.add(splitPane, BorderLayout.CENTER);
        mainPanel.add(statusPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Customer Information & Medicine Search"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);
        
        nameField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel. add(new JLabel("Contact:"), gbc);
        
        contactField = new JTextField(15);
        contactField.setText("0917-1234567");
        gbc.gridx = 1;
        panel. add(contactField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Barangay:"), gbc);
        
        List<Barangay> barangays = barangayManager.getAllBarangays();
        String[] barangayNames = new String[barangays.size()];
        for (int i = 0; i < barangays.size(); i++) {
            barangayNames[i] = barangays.get(i). getName();
        }
        
        barangayCombo = new JComboBox<>(barangayNames);
        barangayCombo.setSelectedIndex(26);
        gbc.gridx = 1;
        panel.add(barangayCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Medicine:"), gbc);
        
        medicineField = new JTextField(15);
        medicineField.setText("Paracetamol");
        gbc.gridx = 1;
        panel.add(medicineField, gbc);

        gbc.gridx = 2;
        addMedicineButton = new JButton("Add");
        addMedicineButton. addActionListener(e -> addMedicineToList());
        panel.add(addMedicineButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Selected Medicines:"), gbc);
        
        medicineListModel = new DefaultListModel<>();
        medicineList = new JList<>(medicineListModel);
        medicineList.setPreferredSize(new Dimension(300, 80));
        
        JScrollPane scrollPane = new JScrollPane(medicineList);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        panel. add(scrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        
        searchButton = new JButton("SEARCH");
        searchButton.setFont(new Font("Arial", Font. BOLD, 14));
        searchButton.setBackground(new Color(0, 120, 215));
        searchButton.setForeground(Color.WHITE);
        searchButton.setOpaque(true);
        searchButton.setBorderPainted(false);
        searchButton.setPreferredSize(new Dimension(120, 40));
        searchButton.addActionListener(e -> performSearch());
        
        clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clearAll());
        
        buttonPanel.add(searchButton);
        buttonPanel.add(clearButton);
        panel.add(buttonPanel, gbc);
        
        return panel;
    }

    private JPanel createResultsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Search Results"));
        
        String[] columnNames = {"Medicine", "Drugstore", "Distance (km)", "Price (₱)", "Available", "Best"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        resultsTable = new JTable(model);
        resultsTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        resultsTable.getColumnModel(). getColumn(1).setPreferredWidth(150);
        resultsTable.getColumnModel().getColumn(2).setPreferredWidth(80);
        resultsTable.getColumnModel().getColumn(3). setPreferredWidth(80);
        resultsTable.getColumnModel().getColumn(4). setPreferredWidth(60);
        resultsTable.getColumnModel().getColumn(5). setPreferredWidth(50);
        resultsTable.setRowHeight(25);
        
        JScrollPane scrollPane = new JScrollPane(resultsTable);
        panel. add(scrollPane, BorderLayout. CENTER);
        
        infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        infoPanel.setBorder(BorderFactory.createTitledBorder("Summary"));
        panel.add(infoPanel, BorderLayout.SOUTH);
        
        return panel;
    }

    private void addMedicineToList() {
        String medicine = medicineField. getText().trim();
        
        if (medicine.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a medicine name", 
                "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (int i = 0; i < medicineListModel.size(); i++) {
            if (medicineListModel.getElementAt(i).equalsIgnoreCase(medicine)) {
                JOptionPane.showMessageDialog(this, "Already added", 
                    "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        medicineListModel.addElement(medicine);
        medicineField.setText("");
        statusLabel.setText("Added: " + medicine);
    }

    private void performSearch() {
        String name = nameField.getText(). trim();
        String contact = contactField.getText().trim();
        
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your name", 
                "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (contact.isEmpty()) {
            JOptionPane. showMessageDialog(this, "Please enter your contact", 
                "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (medicineListModel.size() == 0) {
            JOptionPane.showMessageDialog(this, "Please add at least one medicine", 
                "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {

            List<String> medicines = new ArrayList<>();
            for (int i = 0; i < medicineListModel.size(); i++) {
                medicines. add(medicineListModel.getElementAt(i));
            }
            
            String selectedBarangay = (String) barangayCombo.getSelectedItem();
            if (selectedBarangay == null || selectedBarangay.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a valid barangay", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Barangay barangay = barangayManager.getBarangayByName(selectedBarangay);
            if (barangay == null) {
                JOptionPane.showMessageDialog(this, "Invalid barangay selected: " + selectedBarangay, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            currentCustomer = new Customer(name, contact, barangay.getCenterLocation());

            allMedicineOptions. clear();
            Map<String, DrugstoreResult> bestResults = new LinkedHashMap<>();
            
            for (String medicine : medicines) {
                List<DrugstoreResult> options = graph.findTopDrugstoresForMedicine(
                    currentCustomer.getLocation(),
                    medicine,
                    10
                );
                
                if (! options.isEmpty()) {
                    allMedicineOptions.put(medicine, options);
                    bestResults.put(medicine, options.get(0));
                }
            }

            optimizedResult = new OptimizedSearchResult(medicines, bestResults);

            if (optimizedResult. getBestDrugstoresPerMedicine(). isEmpty()) {
                JOptionPane.showMessageDialog(this, "No medicines found!\n\nTry: Paracetamol, Amoxicillin, Ibuprofen", 
                    "No Results", JOptionPane. INFORMATION_MESSAGE);
                return;
            }

            displayResults();

            mapPanel.setCustomerLocation(currentCustomer.getLocation());
            mapPanel.setMedicineOptions(allMedicineOptions);
            mapPanel.repaint();
            
            statusLabel.setText("✓ Search complete!   Found " + bestResults.size() + " medicine(s)");
            
        } catch (Exception ex) {
            JOptionPane. showMessageDialog(this, "Error: " + ex.getMessage(), 
                "Error", JOptionPane. ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void displayResults() {
        DefaultTableModel model = (DefaultTableModel) resultsTable.getModel();
        model.setRowCount(0);
        
        for (String medicine : optimizedResult.getMedicinesSearched()) {
            List<DrugstoreResult> options = allMedicineOptions.get(medicine);
            
            if (options != null) {
                for (int i = 0; i < Math.min(3, options.size()); i++) {
                    DrugstoreResult result = options. get(i);
                    String isBest = (i == 0) ? "⭐" : "";
                    
                    model. addRow(new Object[]{
                        medicine,
                        result.getStoreName(),
                        String.format("%.2f", result.getDistance()),
                        String.format("%.2f", result.getPrice()),
                        result.getAvailableQuantity(),
                        isBest
                    });
                }
            }
        }
        
        updateSummary();
    }

    private void updateSummary() {
        infoPanel.removeAll();
        
        double cost = optimizedResult.getTotalCost();
        double distance = optimizedResult.getTotalDistance();
        int stores = optimizedResult.getUniqueDrugstoreCount();
        
        infoPanel.add(new JLabel("Total Cost: ₱" + String.format("%.2f", cost)));
        infoPanel.add(new JLabel("Total Distance: " + String.format("%.2f", distance) + " km"));
        infoPanel.add(new JLabel("Stores to Visit: " + stores));
        infoPanel.revalidate();
        infoPanel.repaint();
    }

    private void clearAll() {
        nameField.setText("");
        contactField.setText("0917-1234567");
        medicineListModel.clear();
        medicineField.setText("Paracetamol");
        resultsTable.setModel(new DefaultTableModel(
            new String[]{"Medicine", "Drugstore", "Distance (km)", "Price (₱)", "Available", "Best"}, 0));
        infoPanel.removeAll();
        infoPanel.revalidate();
        mapPanel.clearMap();
        statusLabel.setText("Cleared");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DrugstoreLocatorGUI());
    }
}