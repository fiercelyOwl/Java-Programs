import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnhancedExerciseMaterialsGUI extends JFrame {
    private ExerciseDatabaseLoader exerciseDatabase;
    private MaterialQueue materialQueue;
    private java.util.List<Receipt> generatedReceipts;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel queueCountLabel;
    private JLabel receiptCountLabel;

    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SECONDARY_COLOR = new Color(44, 62, 80);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(241, 196, 15);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);
    private static final Color BG_COLOR = new Color(241, 245, 250);
    private static final Color CARD_BG = Color.WHITE;
    private static final Color TEXT_COLOR = new Color(33, 47, 61);
    private static final Color BORDER_COLOR = new Color(189, 195, 199);

    public EnhancedExerciseMaterialsGUI() {
        this.exerciseDatabase = new ExerciseDatabaseLoader();
        this.materialQueue = new MaterialQueue();
        this.generatedReceipts = new ArrayList<>();

        setTitle("Exercise Materials Queue Management System - Professional Edition");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setResizable(true);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(BG_COLOR);

        mainPanel.add(createDashboardPanel(), "DASHBOARD");
        mainPanel.add(createCustomerRegistrationPanel(), "REGISTRATION");
        mainPanel.add(createProcessCustomerPanel(), "PROCESS");
        mainPanel.add(createQueueStatusPanel(), "QUEUE_STATUS");
        mainPanel.add(createSicknessListPanel(), "SICKNESS_LIST");
        mainPanel.add(createReceiptHistoryPanel(), "RECEIPT_HISTORY");

        add(mainPanel);
        cardLayout.show(mainPanel, "DASHBOARD");
        setVisible(true);
    }


    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(BG_COLOR);
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));


        JPanel bannerPanel = new JPanel();
        bannerPanel.setBackground(PRIMARY_COLOR);
        bannerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bannerPanel.setPreferredSize(new Dimension(0, 80));

        JLabel bannerLabel = new JLabel("Exercise Materials Queue Management System");
        bannerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        bannerLabel.setForeground(Color.WHITE);
        bannerPanel.add(bannerLabel);

        panel.add(bannerPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(BG_COLOR);
        contentPanel.setLayout(new GridLayout(2, 3, 15, 15));
        contentPanel.setBorder(new EmptyBorder(30, 30, 30, 30));

        contentPanel.add(createDashboardCard(" Register New Customer", "Add a new customer to the system",
            PRIMARY_COLOR, e -> cardLayout.show(mainPanel, "REGISTRATION")));

        contentPanel.add(createDashboardCard("Process Next Customer", "Generate receipt and process next in queue",
            SUCCESS_COLOR, e -> cardLayout.show(mainPanel, "PROCESS")));

        contentPanel.add(createDashboardCard(" View Queue Status", "Monitor equipment queue in real-time",
            WARNING_COLOR, e -> cardLayout.show(mainPanel, "QUEUE_STATUS")));

        contentPanel.add(createDashboardCard(" View Exercises", "Browse all available health conditions and exercises",
            SECONDARY_COLOR, e -> cardLayout.show(mainPanel, "SICKNESS_LIST")));

        contentPanel.add(createDashboardCard(" Receipt History", "View all generated receipts",
            new Color(155, 89, 182), e -> cardLayout.show(mainPanel, "RECEIPT_HISTORY")));

        contentPanel.add(createDashboardCard(" Exit System", "Close the application",
            DANGER_COLOR, e -> System.exit(0)));

        panel.add(contentPanel, BorderLayout.CENTER);

        JPanel statusBar = new JPanel();
        statusBar.setBackground(SECONDARY_COLOR);
        statusBar.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        statusBar.setPreferredSize(new Dimension(0, 60));

        queueCountLabel = new JLabel("Queue Items: 0");
        queueCountLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        queueCountLabel.setForeground(Color.WHITE);
        statusBar.add(queueCountLabel);

        receiptCountLabel = new JLabel("Receipts Generated: 0");
        receiptCountLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        receiptCountLabel.setForeground(Color.WHITE);
        statusBar.add(receiptCountLabel);

        panel.add(statusBar, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createDashboardCard(String title, String description, Color bgColor, ActionListener listener) {
        JPanel card = new JPanel();
        card.setBackground(CARD_BG);
        card.setBorder(new LineBorder(bgColor, 2, true));
        card.setLayout(new BorderLayout());
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(bgColor);
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setPreferredSize(new Dimension(0, 50));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);

        card.add(headerPanel, BorderLayout.NORTH);

        JLabel descLabel = new JLabel(description);
        descLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        descLabel.setForeground(TEXT_COLOR);
        descLabel.setHorizontalAlignment(JLabel.CENTER);
        descLabel.setBorder(new EmptyBorder(20, 15, 20, 15));
        descLabel.setVerticalAlignment(JLabel.CENTER);
        card.add(descLabel, BorderLayout.CENTER);

        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listener.actionPerformed(new ActionEvent(card, ActionEvent.ACTION_PERFORMED, ""));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                card.setBackground(new Color(250, 250, 250));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                card.setBackground(CARD_BG);
            }
        });

        return card;
    }

    private JPanel createCustomerRegistrationPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(BG_COLOR);
        panel.setLayout(new BorderLayout());

        JPanel headerPanel = createHeaderPanel("Customer Registration", PRIMARY_COLOR);
        panel.add(headerPanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(BG_COLOR);
        formPanel.setBorder(new EmptyBorder(40, 100, 40, 100));
        formPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 15, 12, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = createFormLabel("Full Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        formPanel.add(nameLabel, gbc);

        JTextField nameField = createFormTextField(30);
        gbc.gridx = 1;
        gbc.weightx = 1;
        formPanel.add(nameField, gbc);

        JLabel contactLabel = createFormLabel("Contact Number:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        formPanel.add(contactLabel, gbc);

        JTextField contactField = createFormTextField(30);
        gbc.gridx = 1;
        gbc.weightx = 1;
        formPanel.add(contactField, gbc);

        JLabel sicknessLabel = createFormLabel("Health Condition:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        formPanel.add(sicknessLabel, gbc);

        Set<String> sicknessSet = exerciseDatabase.getAllSicknessCategories();
        java.util.List<String> sicknessList = new ArrayList<>(sicknessSet);
        Collections.sort(sicknessList);
        JComboBox<String> sicknessCombo = createFormComboBox(sicknessList.toArray(new String[0]));
        gbc.gridx = 1;
        gbc.weightx = 1;
        formPanel.add(sicknessCombo, gbc);

        JLabel exerciseLabel = createFormLabel("Select Exercise:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        formPanel.add(exerciseLabel, gbc);

        JComboBox<String> exerciseCombo = createFormComboBox(new String[]{});
        gbc.gridx = 1;
        gbc.weightx = 1;
        formPanel.add(exerciseCombo, gbc);

        sicknessCombo.addActionListener(e -> {
            exerciseCombo.removeAllItems();
            String selectedSickness = (String) sicknessCombo.getSelectedItem();
            if (selectedSickness != null) {
                java.util.List<ExerciseMaterial> exercises = exerciseDatabase.getExercisesBySickness(selectedSickness);
                for (ExerciseMaterial exercise : exercises) {
                    exerciseCombo.addItem(exercise.getExerciseName());
                }
            }
        });

        if (sicknessCombo.getItemCount() > 0) {
            sicknessCombo.setSelectedIndex(0);
        }

        gbc.gridy = 4;
        formPanel.add(Box.createVerticalStrut(30), gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(BG_COLOR);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));

        JButton registerButton = createActionButton("Register Customer", SUCCESS_COLOR);
        registerButton.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                String contact = contactField.getText().trim();
                String sickness = (String) sicknessCombo.getSelectedItem();
                String exercise = (String) exerciseCombo.getSelectedItem();

                if (name.isEmpty() || contact.isEmpty() || exercise == null) {
                    showDialog("Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Customer customer = new Customer(name, contact, sickness, exercise);
                ExerciseMaterial exerciseMaterial = exerciseDatabase.getExercise(exercise);

                if (exerciseMaterial != null) {
                    Queue<Equipment> equipment = exerciseMaterial.getRequiredEquipment();
                    while (!equipment.isEmpty()) {
                        materialQueue.enqueueEquipment(customer, equipment.poll());
                    }
                    updateQueueLabel();
                    showDialog("Customer #" + customer.getCustomerNumber() + " registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    nameField.setText("");
                    contactField.setText("");
                }
            } catch (IllegalArgumentException ex) {
                showDialog("Error: " + ex.getMessage(), "Registration Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonPanel.add(registerButton);

        JButton backButton = createActionButton("Back to Dashboard", SECONDARY_COLOR);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "DASHBOARD"));
        buttonPanel.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(buttonPanel, gbc);

        panel.add(formPanel, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createProcessCustomerPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(BG_COLOR);
        panel.setLayout(new BorderLayout());

        JPanel headerPanel = createHeaderPanel("Process Customer & Generate Receipt", SUCCESS_COLOR);
        panel.add(headerPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(BG_COLOR);
        contentPanel.setLayout(new BorderLayout(10, 10));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JTextArea receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Courier New", Font.PLAIN, 10));
        receiptArea.setBackground(CARD_BG);
        receiptArea.setForeground(TEXT_COLOR);
        receiptArea.setBorder(new TitledBorder(new LineBorder(BORDER_COLOR, 1), "Receipt Preview", TitledBorder.LEFT, TitledBorder.TOP));
        receiptArea.setText("Receipt will appear here after processing a customer.");

        JScrollPane scrollPane = new JScrollPane(receiptArea);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(BG_COLOR);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        JButton processButton = createActionButton("Process Next Customer", SUCCESS_COLOR);
        processButton.addActionListener(e -> {
            if (materialQueue.isEmpty()) {
                receiptArea.setText("Queue is empty. Please register customers first.");
                showDialog("No customers in queue.", "Queue Empty", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            try {
                Map<Customer, java.util.List<Equipment>> customerEquipment = new HashMap<>();

                while (!materialQueue.isEmpty()) {
                    var nextItem = materialQueue.peekEquipment();
                    if (nextItem == null) break;

                    Customer currentCustomer = nextItem.getCustomer();
                    var item = materialQueue.dequeueEquipment();
                    customerEquipment.putIfAbsent(item.getCustomer(), new ArrayList<>());
                    customerEquipment.get(item.getCustomer()).add(item.getEquipment());

                    if (materialQueue.isEmpty() ||
                        (materialQueue.peekEquipment() != null &&
                         !materialQueue.peekEquipment().getCustomer().equals(currentCustomer))) {
                        break;
                    }
                }

                if (!customerEquipment.isEmpty()) {
                    Customer processedCustomer = customerEquipment.keySet().iterator().next();
                    java.util.List<Equipment> equipmentList = customerEquipment.get(processedCustomer);

                    Receipt receipt = new Receipt(processedCustomer, equipmentList);
                    generatedReceipts.add(receipt);

                    receiptArea.setText(receipt.generateReceipt());
                    updateQueueLabel();
                    updateReceiptLabel();
                    showDialog("Customer processed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                showDialog("Error:  " + ex.getMessage(), "Processing Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonPanel.add(processButton);

        JButton printButton = createActionButton("Print Receipt", PRIMARY_COLOR);
        printButton.addActionListener(e -> {
            if (receiptArea.getText().equals("Receipt will appear here after processing a customer... ")) {
                showDialog("No receipt to print.", "Print Error", JOptionPane.WARNING_MESSAGE);
            } else {
                showDialog("Receipt printed successfully!", "Print", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buttonPanel.add(printButton);

        JButton backButton = createActionButton("Back to Dashboard", SECONDARY_COLOR);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "DASHBOARD"));
        buttonPanel.add(backButton);

        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(contentPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createQueueStatusPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(BG_COLOR);
        panel.setLayout(new BorderLayout());

        JPanel headerPanel = createHeaderPanel("Real-Time Queue Status", WARNING_COLOR);
        panel.add(headerPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(BG_COLOR);
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setLayout(new BorderLayout(10, 10));

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(CARD_BG);
        infoPanel.setBorder(new LineBorder(BORDER_COLOR, 1));
        infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
        infoPanel.setPreferredSize(new Dimension(0, 60));

        JLabel queueSizeLabel = new JLabel("Total Queue Items: 0");
        queueSizeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        queueSizeLabel.setForeground(PRIMARY_COLOR);
        infoPanel.add(queueSizeLabel);

        contentPanel.add(infoPanel, BorderLayout.NORTH);

        String[] columnNames = {"Position", "Customer #", "Customer Name", "Equipment", "Contact"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable queueTable = new JTable(tableModel);
        queueTable.setFont(new Font("Arial", Font.PLAIN, 11));
        queueTable.setRowHeight(25);
        queueTable.getTableHeader().setBackground(WARNING_COLOR);
        queueTable.getTableHeader().setForeground(Color.WHITE);
        queueTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        queueTable.setSelectionBackground(new Color(255, 240, 200));

        JScrollPane scrollPane = new JScrollPane(queueTable);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(BG_COLOR);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        JButton refreshButton = createActionButton("Refresh Queue", PRIMARY_COLOR);
        refreshButton.addActionListener(e -> {
            tableModel.setRowCount(0);
            java.util.List<MaterialQueue.EquipmentQueueItem> queueItems = materialQueue.getQueueItems();
            int position = 1;
            for (MaterialQueue.EquipmentQueueItem item : queueItems) {
                tableModel.addRow(new Object[]{
                    position,
                    "#" + item.getCustomer().getCustomerNumber(),
                    item.getCustomer().getCustomerName(),
                    item.getEquipment().getEquipmentName(),
                    item.getCustomer().getContactNumber()
                });
                position++;
            }
            queueSizeLabel.setText("Total Queue Items: " + materialQueue.getQueueSize());
            showDialog("Queue refreshed successfully!", "Refresh", JOptionPane.INFORMATION_MESSAGE);
        });
        buttonPanel.add(refreshButton);

        JButton backButton = createActionButton("Back to Dashboard", SECONDARY_COLOR);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "DASHBOARD"));
        buttonPanel.add(backButton);

        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(contentPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createSicknessListPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(BG_COLOR);
        panel.setLayout(new BorderLayout());

        JPanel headerPanel = createHeaderPanel("Available Health Conditions & Exercises", SECONDARY_COLOR);
        panel.add(headerPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(BG_COLOR);
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setLayout(new BorderLayout());

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Health Conditions");
        Set<String> sicknesses = exerciseDatabase.getAllSicknessCategories();
        java.util.List<String> sortedSicknesses = new ArrayList<>(sicknesses);
        Collections.sort(sortedSicknesses);

        for (String sickness : sortedSicknesses) {
            DefaultMutableTreeNode sicknessNode = new DefaultMutableTreeNode("  " + sickness);
            java.util.List<ExerciseMaterial> exercises = exerciseDatabase.getExercisesBySickness(sickness);
            for (ExerciseMaterial exercise : exercises) {
                DefaultMutableTreeNode exerciseNode = new DefaultMutableTreeNode("    ➤ " + exercise.getExerciseName());
                sicknessNode.add(exerciseNode);
            }
            rootNode.add(sicknessNode);
        }

        JTree tree = new JTree(rootNode);
        tree.setFont(new Font("Arial", Font.PLAIN, 12));
        tree.setBackground(CARD_BG);

        JScrollPane treeScrollPane = new JScrollPane(tree);
        contentPanel.add(treeScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(BG_COLOR);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        JButton backButton = createActionButton("Back to Dashboard", SECONDARY_COLOR);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "DASHBOARD"));
        buttonPanel.add(backButton);

        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(contentPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createReceiptHistoryPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(BG_COLOR);
        panel.setLayout(new BorderLayout());

        JPanel headerPanel = createHeaderPanel("Receipt History", new Color(155, 89, 182));
        panel.add(headerPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(BG_COLOR);
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setLayout(new BorderLayout(10, 10));

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(CARD_BG);
        infoPanel.setBorder(new LineBorder(BORDER_COLOR, 1));
        infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
        infoPanel.setPreferredSize(new Dimension(0, 60));

        JLabel totalReceiptsLabel = new JLabel("Total Receipts Generated: 0");
        totalReceiptsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        totalReceiptsLabel.setForeground(PRIMARY_COLOR);
        infoPanel.add(totalReceiptsLabel);

        contentPanel.add(infoPanel, BorderLayout.NORTH);

        String[] columnNames = {"Receipt #", "Customer #", "Customer Name", "Total Cost", "Date & Time"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable receiptTable = new JTable(tableModel);
        receiptTable.setFont(new Font("Arial", Font.PLAIN, 11));
        receiptTable.setRowHeight(25);
        receiptTable.getTableHeader().setBackground(new Color(155, 89, 182));
        receiptTable.getTableHeader().setForeground(Color.WHITE);
        receiptTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        receiptTable.setSelectionBackground(new Color(221, 205, 240));

        JScrollPane scrollPane = new JScrollPane(receiptTable);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(BG_COLOR);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        JButton refreshButton = createActionButton("Refresh History", PRIMARY_COLOR);
        refreshButton.addActionListener(e -> {
            tableModel.setRowCount(0);
            for (Receipt receipt : generatedReceipts) {
                tableModel.addRow(new Object[]{
                    "#" + receipt.getReceiptNumber(),
                    "#" + receipt.getCustomer().getCustomerNumber(),
                    receipt.getCustomer().getCustomerName(),
                    "₱" + String.format("%.2f", receipt.getTotalCost()),
                    receipt.getTransactionTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                });
            }
            totalReceiptsLabel.setText("Total Receipts Generated: " + generatedReceipts.size());
        });
        buttonPanel.add(refreshButton);

        JButton backButton = createActionButton("Back to Dashboard", SECONDARY_COLOR);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "DASHBOARD"));
        buttonPanel.add(backButton);

        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(contentPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createHeaderPanel(String title, Color bgColor) {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(bgColor);
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
        headerPanel.setPreferredSize(new Dimension(0, 60));

        JLabel headerLabel = new JLabel(title);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        return headerPanel;
    }

    private JLabel createFormLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setForeground(TEXT_COLOR);
        return label;
    }

    private JTextField createFormTextField(int columns) {
        JTextField textField = new JTextField(columns);
        textField.setFont(new Font("Arial", Font.PLAIN, 12));
        textField.setBackground(CARD_BG);
        textField.setForeground(TEXT_COLOR);
        textField.setBorder(new LineBorder(BORDER_COLOR, 1));
        return textField;
    }

    private JComboBox<String> createFormComboBox(String[] items) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
        comboBox.setBackground(CARD_BG);
        comboBox.setForeground(TEXT_COLOR);
        return comboBox;
    }

    private JButton createActionButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(180, 40));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(bgColor.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });

        return button;
    }

    private void updateQueueLabel() {
        queueCountLabel.setText("Queue Items: " + materialQueue.getQueueSize());
    }

    private void updateReceiptLabel() {
        receiptCountLabel.setText("Receipts Generated: " + generatedReceipts.size());
    }

    private void showDialog(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EnhancedExerciseMaterialsGUI());
    }
}
