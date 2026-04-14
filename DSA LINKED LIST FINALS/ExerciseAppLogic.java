import javax.swing.*;
import java.awt.*;
import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator; 
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class ExerciseAppLogic {
    private ExerciseList exercises;
    public ExerciseAppLogic() {
        exercises = new ExerciseList();
        new ExerciseData(exercises); 
    }
    
    private String toTitleCase(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        String lowerCase = input.toLowerCase();
        
        StringBuilder titleCase = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : lowerCase.toCharArray()) {
            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
                titleCase.append(c);
            } else if (capitalizeNext) {
                titleCase.append(Character.toTitleCase(c));
                capitalizeNext = false;
            } else {
                titleCase.append(c);
            }
        }
        return titleCase.toString();
    }

    public void startApp() {
        final String THEME_COLOR = "#2E8B57"; 
        final Color BG_COLOR = null; 

        JTextField nameField = new JTextField(20);
        JTextField diseaseField = new JTextField(20);
        
        JButton findExercisesButton = new JButton("Find Exercises");
        findExercisesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        findExercisesButton.setBackground(Color.decode(THEME_COLOR));
        findExercisesButton.setForeground(Color.WHITE);
        
        nameField.setPreferredSize(new Dimension(200, 25));
        diseaseField.setPreferredSize(new Dimension(200, 25));

        JDialog startDialog = new JDialog((Frame) null, "Welcome! - Exercise Program", true);
        
        startDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
        startDialog.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); 
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(BG_COLOR); 
        
        JLabel titleLabel = new JLabel("Exercise Program");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 18f));
        titleLabel.setForeground(Color.decode(THEME_COLOR));
        inputPanel.add(titleLabel);
        inputPanel.add(Box.createVerticalStrut(15)); 

        JLabel instructionLabel = new JLabel("Please enter your details to find personalized exercises.");
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(instructionLabel);
        inputPanel.add(Box.createVerticalStrut(25)); 

        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        fieldsPanel.setBackground(BG_COLOR); 
        fieldsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        gbc.insets = new Insets(5, 0, 5, 20); 

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        fieldsPanel.add(new JLabel("<html><b>Name:</b></html>"), gbc); 

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        fieldsPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        fieldsPanel.add(new JLabel("<html><b>Disease/Condition:</b></html>"), gbc); 

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        fieldsPanel.add(diseaseField, gbc);

        inputPanel.add(fieldsPanel);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(findExercisesButton);
        
        startDialog.add(inputPanel, BorderLayout.CENTER);
        startDialog.add(buttonPanel, BorderLayout.SOUTH);

        findExercisesButton.addActionListener(e -> {
            String rawUserName = nameField.getText().trim();
            String rawUserDisease = diseaseField.getText().trim();

            if (rawUserName.isEmpty() || rawUserDisease.isEmpty()) {
                JOptionPane.showMessageDialog(startDialog, "Both name and condition are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            startDialog.dispose();
            
            String userName = toTitleCase(rawUserName);
            String userDisease = toTitleCase(rawUserDisease);

            showExerciseSelectionDialog(userName, userDisease); 
        });

        startDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                startDialog.dispose();
                JOptionPane.showMessageDialog(null, "Application closing. Goodbye!", "Exiting..", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        startDialog.pack();
        startDialog.setLocationRelativeTo(null); 
        startDialog.setVisible(true); 
    }
	
	
	private void showExerciseSelectionDialog(String userName, String userDisease) {
		ArrayList<ExerciseNode> filteredExercises = exercises.getExercisesByDisease(userDisease);

		if (filteredExercises.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Sorry, " + userName + ". No exercises found for '" + userDisease + "'.", "No Results", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		JDialog selectionDialog = new JDialog((Frame) null, "Exercise Selection", true); 
		selectionDialog.setLayout(new BorderLayout(10, 10));
		selectionDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
		final String THEME_COLOR = "#2E8B57";
		
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
		headerPanel.setBorder(new EmptyBorder(15, 20, 15, 20));
		headerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		JLabel nameLabelBold = new JLabel("Name: ");
		nameLabelBold.setFont(new Font("SansSerif", Font.BOLD, 14));
		nameLabelBold.setForeground(new Color(85, 85, 85)); // #555555

		JLabel nameValue = new JLabel(userName);
		nameValue.setFont(new Font("SansSerif", Font.PLAIN, 14));
		nameValue.setForeground(new Color(85, 85, 85));

		namePanel.add(nameLabelBold);
		namePanel.add(nameValue);

		JPanel condPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		JLabel condLabelBold = new JLabel("Condition: ");
		condLabelBold.setFont(new Font("SansSerif", Font.BOLD, 14));
		condLabelBold.setForeground(new Color(85, 85, 85));

		JLabel condValue = new JLabel(userDisease);
		condValue.setFont(new Font("SansSerif", Font.PLAIN, 14));
		condValue.setForeground(new Color(85, 85, 85));

		condPanel.add(condLabelBold);
		condPanel.add(condValue);

		JLabel suitedLabel = new JLabel("SUITED EXERCISES:");
		suitedLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		suitedLabel.setForeground(new Color(46,139,87)); 
		suitedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		headerPanel.add(namePanel);
		headerPanel.add(Box.createVerticalStrut(5));
		headerPanel.add(condPanel);
		headerPanel.add(Box.createVerticalStrut(15));
		headerPanel.add(suitedLabel);

		selectionDialog.add(headerPanel, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.setBorder(new EmptyBorder(0, 20, 20, 20)); 
		
		for (ExerciseNode ex : filteredExercises) {
			JButton exerciseButton = new JButton("➡️ " + ex.getName()); 
			exerciseButton.setAlignmentX(Component.LEFT_ALIGNMENT);
			exerciseButton.setMaximumSize(new Dimension(300, 35)); 
			exerciseButton.setHorizontalAlignment(SwingConstants.LEFT); 
			
			exerciseButton.addActionListener(e -> {
				showExerciseDetails(ex);
			});

			buttonPanel.add(exerciseButton);
			buttonPanel.add(Box.createVerticalStrut(5));
		}
		
		JScrollPane scrollPane = new JScrollPane(buttonPanel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null); 
		
		selectionDialog.add(scrollPane, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		southPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

		JButton doneButton = new JButton("    Done    "); 
		doneButton.setBackground(new Color(46, 139, 87)); 
		doneButton.setForeground(Color.WHITE);
		doneButton.setFocusPainted(false);
		doneButton.setFont(doneButton.getFont().deriveFont(Font.BOLD, 14f));

		doneButton.addActionListener(e -> {
			selectionDialog.dispose(); 
			showCompletionSummary(userName, userDisease, filteredExercises); 
		});

		southPanel.add(doneButton);
		selectionDialog.add(southPanel, BorderLayout.SOUTH);

		selectionDialog.pack();
		selectionDialog.setLocationRelativeTo(null); 
		selectionDialog.setVisible(true); 
	}

	private void showExerciseDetails(ExerciseNode exercise) {
        final String THEME_COLOR = "#2E8B57"; 
        final String HEADER_COLOR = "#333333";
        final String EMOJI = "🎬"; 

        String exerciseNameHtml = "<span style='color: " + THEME_COLOR + ";'>" + exercise.getName() + "</span>";
        
        String fullMessage = "<html><body style='width: 400px; padding: 10px;'>" + 
            
            "<center>" + 
            "<h2><b>" + exerciseNameHtml + "</b></h2>" + 
            "<span style='font-size: 11pt; color: #555555; margin-top: 5px; margin-bottom: 5px;'>Targeting: " + exercise.getDisease() + "</span>" + 
            "</center>" +
            
            "<hr style='margin-top: 10px; margin-bottom: 20px; border-top: 2px solid #333333;'>" + 
            
            "<h3 style='color: " + HEADER_COLOR + "; margin: 0 0 5px 0; text-align: left;'><b>DESCRIPTION</b></h3>" +
            "<p style='text-align: justify; margin-left: 15px; margin-right: 15px;'>" + exercise.getDescription() + "</p>" +
            
            "<h3 style='color: " + HEADER_COLOR + "; margin: 20px 0 5px 0; text-align: left;'><b>HOW TO DO IT?</b></h3>" +
            "<p style='text-align: justify; margin-left: 15px; margin-right: 15px;'>" + exercise.getInstructions() + "</p>" +
            
            "<h3 style='color: " + HEADER_COLOR + "; margin: 20px 0 5px 0; text-align: left;'><b>REPETITION</b></h3>" +
            "<p style='text-align: justify; margin-left: 15px; margin-right: 15px;'>" +
            exercise.getRepetitions() +
            "</p>" +
            
            "<h3 style='color: " + HEADER_COLOR + "; margin: 20px 0 5px 0; text-align: left;'><b>BENEFITS</b></h3>" +
            "<div style='text-align: left; margin-left: 15px; margin-right: 15px;'>" + 
            exercise.getBenefits() + 
            "</div>" +
            
            "<hr style='margin-top: 20px; border-top: 1px solid #AAAAAA;'>" + 
            
            "<center>" + 
            "<p style='margin: 15px 0 0 0; font-size: 12pt; color: " + THEME_COLOR + ";'>" + 
            "<b>" + EMOJI + " Would you like to watch the video tutorial?</b>" + 
            "</p>" +
            "</center>" +
            
            "</body></html>";

        int choice = JOptionPane.showConfirmDialog(
            null,
            fullMessage, 
            "Exercise Details",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.PLAIN_MESSAGE 
        );

        if (choice == JOptionPane.YES_OPTION) {
            openVideoLink(exercise.getVideoLink());
        }
	}

	private void showCompletionSummary(String userName, String userDisease, ArrayList<ExerciseNode> exercises) {
		final Color THEME_COLOR = new Color(46, 139, 87);
		final int DIALOG_WIDTH = 550;

		JDialog summaryDialog = new JDialog((Frame) null, "Session Complete!", true);
		summaryDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		summaryDialog.getContentPane().setBackground(Color.WHITE);
		summaryDialog.setLayout(new BorderLayout()); 

		JPanel congratsPanel = new JPanel();
		congratsPanel.setLayout(new BoxLayout(congratsPanel, BoxLayout.Y_AXIS));
		congratsPanel.setBorder(new EmptyBorder(20, 20, 5, 20)); 
		congratsPanel.setBackground(Color.WHITE);
		congratsPanel.setOpaque(true);

		JLabel titleLabel = new JLabel("CONGRATULATIONS, " + userName.toUpperCase() + "!");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
		titleLabel.setForeground(THEME_COLOR);
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		congratsPanel.add(titleLabel);

		JLabel subtitleLabel = new JLabel("You have successfully completed your exercises for " + userDisease.toUpperCase() + ".");
		subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		subtitleLabel.setForeground(new Color(85, 85, 85));
		subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		congratsPanel.add(Box.createVerticalStrut(5));
		congratsPanel.add(subtitleLabel);
		
		congratsPanel.add(Box.createVerticalStrut(10));
		JSeparator headerSeparator = new JSeparator(SwingConstants.HORIZONTAL);
		headerSeparator.setForeground(Color.BLACK);
		congratsPanel.add(headerSeparator);
		congratsPanel.add(Box.createVerticalStrut(10));

		summaryDialog.add(congratsPanel, BorderLayout.NORTH);

		JPanel summaryPanel = new JPanel();
		summaryPanel.setLayout(new BoxLayout(summaryPanel, BoxLayout.Y_AXIS));
		summaryPanel.setBorder(new EmptyBorder(5, 20, 5, 20)); 
		summaryPanel.setBackground(Color.WHITE);
		summaryPanel.setOpaque(true);

		JLabel summaryHeader = new JLabel("SUMMARY OF RECOMMENDED EXERCISES:");
		summaryHeader.setFont(new Font("Arial", Font.BOLD, 14));
		summaryHeader.setAlignmentX(Component.LEFT_ALIGNMENT);
		summaryPanel.add(summaryHeader);
		summaryPanel.add(Box.createVerticalStrut(5));

		StringBuilder listContent = new StringBuilder();
		listContent.append("<html><body style='font-family: Arial; margin: 0; padding: 0; line-height:1.6;'>"); 
		for (ExerciseNode ex : exercises) {
			listContent.append("• <b>")
				.append(ex.getName()).append("</b>: ")
				.append(ex.getRepetitions())
				.append("<br>");
		}
		listContent.append("</body></html>");

		JTextPane exercisesPane = new JTextPane();
		exercisesPane.setContentType("text/html");
		exercisesPane.setText(listContent.toString());
		exercisesPane.setEditable(false);
		exercisesPane.setBackground(Color.WHITE);
		exercisesPane.setOpaque(true);
		exercisesPane.setBorder(null);
		exercisesPane.setAlignmentX(Component.LEFT_ALIGNMENT);

		summaryPanel.add(exercisesPane);
		
		summaryPanel.add(Box.createVerticalStrut(10));
		JSeparator summarySeparator = new JSeparator(SwingConstants.HORIZONTAL);
		summarySeparator.setForeground(Color.BLACK);
		summaryPanel.add(summarySeparator);

		summaryDialog.add(summaryPanel, BorderLayout.CENTER);

		JPanel footerPanel = new JPanel();
		footerPanel.setLayout(new BoxLayout(footerPanel, BoxLayout.Y_AXIS));
		footerPanel.setBorder(new EmptyBorder(10, 20, 20, 20)); 
		footerPanel.setBackground(Color.WHITE);
		footerPanel.setOpaque(true);

		JLabel closingMessage = new JLabel("Remember to rest and be consistent!");
		closingMessage.setFont(new Font("Arial", Font.BOLD, 14));
		closingMessage.setForeground(new Color(204, 51, 51));
		closingMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
		footerPanel.add(closingMessage);

		footerPanel.add(Box.createVerticalStrut(10));

		JButton okButton = new JButton("Exit");
		okButton.setBackground(THEME_COLOR);
		okButton.setForeground(Color.WHITE);
		okButton.setFocusPainted(false);
		okButton.setFont(new Font("Arial", Font.BOLD, 14));
		okButton.setPreferredSize(new Dimension(200, 35));
		okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		okButton.addActionListener(e -> {
			summaryDialog.dispose();
			System.exit(0);
		});

		footerPanel.add(okButton);
		summaryDialog.add(footerPanel, BorderLayout.SOUTH);

		summaryDialog.pack();
		summaryDialog.setSize(DIALOG_WIDTH, summaryDialog.getHeight());
		summaryDialog.setLocationRelativeTo(null);
		summaryDialog.setVisible(true);
	}

    private void openVideoLink(String url) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                JOptionPane.showMessageDialog(null, "Automatic browser opening is not supported on this system.\nVideo Link: " + url, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unable to open video link: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}