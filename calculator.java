import javax.swing.*;
import java.awt.*;

public class Calculator {

  // Frame and Panels
  private JFrame frame;
  private JPanel buttonPanel;
  private JTextField textfield;

  // Buttons
  private JButton[] numberButtons = new JButton[10];
  private JButton[] functionButtons = new JButton[9];

  // Function Buttons
  private JButton addButton, subButton, divButton, mulButton, eqButton, decButton, delButton, negButton, modButton;

  // Constructor
  public Calculator() {
    initializeFrame();
    initializeTextField();
    initializeButtons();
    addButtonsToPanel();
    finalizeUI();
  }

  // Method to Initialize the Frame
  private void initializeFrame() {
    frame = new JFrame("Crazy Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);
    frame.setLocationRelativeTo(null); // Center the window on the screen
    frame.setLayout(new BorderLayout());
  }

  // Method to Initialize the Text Field
  private void initializeTextField() {
    textfield = new JTextField();
    textfield.setFont(new Font("Roboto", Font.BOLD, 32)); // Set the display to use "Roboto"
    textfield.setBackground(new Color(51, 51, 51)); // Equivalent to #333333
    textfield.setForeground(Color.BLUE);
    textfield.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    textfield.setHorizontalAlignment(JTextField.RIGHT);
    textfield.setEditable(false);
    textfield.setPreferredSize(new Dimension(300, 100));
    textfield.setForeground(Color.WHITE); // White text
    frame.add(textfield, BorderLayout.NORTH); // Add to the top of the frame
  }

  // Method to Initialize the Buttons
  private void initializeButtons() {
    // Initialize number buttons (0-9)
    for (int i = 0; i < 10; i++) {
      numberButtons[i] = new JButton(String.valueOf(i));
      numberButtons[i].setFont(new Font("Arial", Font.BOLD, 20)); // Set font
    }

    // Initialize function buttons (operations and other functions)
    addButton = new JButton("+");
    subButton = new JButton("-");
    divButton = new JButton("/");
    mulButton = new JButton("X");
    eqButton = new JButton("=");
    decButton = new JButton(".");
    delButton = new JButton("C");
    negButton = new JButton("+-");
    modButton = new JButton("%");

    // Add all function buttons to the array
    functionButtons[0] = addButton;
    functionButtons[1] = subButton;
    functionButtons[2] = divButton;
    functionButtons[3] = mulButton;
    functionButtons[4] = eqButton;
    functionButtons[5] = decButton;
    functionButtons[6] = delButton;
    functionButtons[7] = negButton;
    functionButtons[8] = modButton;

    // Set font for all function buttons
    for (JButton button : functionButtons) {
      button.setFont(new Font("Arial", Font.BOLD, 20));
    }
  }

  // Method to Add Buttons to the Panel
  private void addButtonsToPanel() {
    // Initialize button panel with GridBagLayout
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridBagLayout()); // Using GridBagLayout
    GridBagConstraints c = new GridBagConstraints();

    // Set common GridBagConstraints properties
    c.weightx = 1;
    c.weighty = 1;
    c.fill = GridBagConstraints.BOTH; // Fill the entire cell
    c.insets = new Insets(5, 5, 5, 5); // Adding spacing between buttons

    // Add buttons to the panel in the desired order with proper constraints

    // First row (C, +/-, %, /)
    c.gridx = 0;
    c.gridy = 0;
    buttonPanel.add(delButton, c); // C
    c.gridx = 1;
    buttonPanel.add(negButton, c); // +/-
    c.gridx = 2;
    buttonPanel.add(modButton, c); // %
    c.gridx = 3;
    buttonPanel.add(divButton, c); // /

    // Second row (7, 8, 9, X)
    c.gridy = 1;
    c.gridx = 0;
    buttonPanel.add(numberButtons[7], c);
    c.gridx = 1;
    buttonPanel.add(numberButtons[8], c);
    c.gridx = 2;
    buttonPanel.add(numberButtons[9], c);
    c.gridx = 3;
    buttonPanel.add(mulButton, c); // X

    // Third row (4, 5, 6, -)
    c.gridy = 2;
    c.gridx = 0;
    buttonPanel.add(numberButtons[4], c);
    c.gridx = 1;
    buttonPanel.add(numberButtons[5], c);
    c.gridx = 2;
    buttonPanel.add(numberButtons[6], c);
    c.gridx = 3;
    buttonPanel.add(subButton, c); // -

    // Fourth row (1, 2, 3, +)
    c.gridy = 3;
    c.gridx = 0;
    buttonPanel.add(numberButtons[1], c);
    c.gridx = 1;
    buttonPanel.add(numberButtons[2], c);
    c.gridx = 2;
    buttonPanel.add(numberButtons[3], c);
    c.gridx = 3;
    buttonPanel.add(addButton, c); // +

    // Fifth row (0, ., =)
    c.gridy = 4;
    c.gridx = 0;
    buttonPanel.add(numberButtons[0], c); // 0 button (single column)
    c.gridx = 1;
    buttonPanel.add(decButton, c); // . button (single column)

    // Make the "=" button span two columns
    c.gridx = 2;
    c.gridwidth = 2; // Span two columns
    buttonPanel.add(eqButton, c); // = button

    // Add button panel to the frame
    frame.add(buttonPanel, BorderLayout.CENTER); // Add button panel to the center
  }

  // Finalize and Display the UI
  private void finalizeUI() {
    frame.setVisible(true);
  }

  // Main Method to Run the Calculator
  public static void main(String[] args) {
    new Calculator();
  }
}
