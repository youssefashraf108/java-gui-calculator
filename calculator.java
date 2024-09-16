import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Create RoundedButton class to make buttons with rounded corners
// Create RoundedButton class to make buttons with rounded corners
class RoundedButton extends JButton {
  private int radius;
  private Color normalColor;
  private Color hoverColor;

  public RoundedButton(String text, int radius) {
    super(text); // Call the JButton constructor with the button text
    this.radius = radius;
    setFocusPainted(false); // Remove the focus painting
    setContentAreaFilled(false); // No default background fill
    setOpaque(false); // Make it non-opaque for transparency

    // Store the default and hover colors
    // rgba(79,60,208,255)
    normalColor = new Color(79, 60, 208, 255);
    hoverColor = new Color(61, 43, 183, 255); // Red for hover effect

    // Add a MouseListener to handle the hover effect
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        setBackground(hoverColor); // Set hover color when the mouse enters
        repaint();
      }

      @Override
      public void mouseExited(MouseEvent e) {
        setBackground(normalColor); // Revert to normal color when the mouse exits
        repaint();
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Set the background color for the button
    g2.setColor(getBackground());
    g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius); // Draw rounded rectangle

    super.paintComponent(g); // Call parent paint
  }

  @Override
  protected void paintBorder(Graphics g) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Draw rounded border
    g2.setColor(getForeground());
    g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

    g2.dispose();
  }
}

public class Calculator {

  // Frame and Panels
  private JFrame frame;
  private JPanel buttonPanel;
  private JTextField textfield;

  // Buttons
  private RoundedButton[] numberButtons = new RoundedButton[10];
  private RoundedButton[] functionButtons = new RoundedButton[9];

  // Function Buttons
  private RoundedButton addButton, subButton, divButton, mulButton, eqButton, decButton, delButton, negButton,
      modButton;

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
    textfield.setForeground(Color.WHITE);
    textfield.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    textfield.setHorizontalAlignment(JTextField.RIGHT);
    textfield.setEditable(false);
    textfield.setPreferredSize(new Dimension(300, 100));
    frame.add(textfield, BorderLayout.NORTH); // Add to the top of the frame
  }

  // Method to Initialize the Buttons
  private void initializeButtons() {
    // Initialize number buttons (0-9)
    for (int i = 0; i < 10; i++) {
      numberButtons[i] = new RoundedButton(String.valueOf(i), 30); // Use RoundedButton with radius 30
      numberButtons[i].setFont(new Font("Roboto", Font.BOLD, 32)); // Set font
      numberButtons[i].setBackground(new Color(79, 60, 208, 255)); // Set background color
      numberButtons[i].setForeground(new Color(243, 238, 248, 255)); // Set text color
    }

    // Initialize function buttons (operations and other functions)
    addButton = new RoundedButton("+", 30);
    subButton = new RoundedButton("-", 30);
    divButton = new RoundedButton("/", 30);
    mulButton = new RoundedButton("X", 30);
    eqButton = new RoundedButton("=", 30);
    decButton = new RoundedButton(".", 30);
    delButton = new RoundedButton("C", 30);
    negButton = new RoundedButton("+-", 30);
    modButton = new RoundedButton("%", 30);

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
    for (RoundedButton button : functionButtons) {
      button.setFont(new Font("Roboto", Font.BOLD, 32)); // Set font
      button.setBackground(new Color(79, 60, 208, 255)); // Set background to purple
      button.setForeground(new Color(243, 238, 248, 255)); // Set text color to white for contrast
    }
    // Set color of the "=" button to rgba(243, 61, 29, 255)
    eqButton.setBackground(new Color(243, 61, 29, 255)); // Set the "=" button color to red

  }

  // Method to Add Buttons to the Panel
  private void addButtonsToPanel() {
    // Initialize button panel with GridBagLayout
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridBagLayout()); // Using GridBagLayout
    GridBagConstraints c = new GridBagConstraints();
    buttonPanel.setBackground(new Color(42, 52, 62, 255)); // Set background color

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
    buttonPanel.add(numberButtons[0], c); // 0 button
    c.gridx = 1;
    buttonPanel.add(decButton, c); // . button

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
