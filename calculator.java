import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator {
  JFrame frame;
  JPanel panel;
  JTextField textfield;
  JPanel buttonPanel;
  JButton[] numberButtons = new JButton[10];
  JButton[] functionButtons = new JButton[9];

  public calculator() {
    frame = new JFrame(" Crazy Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);

    frame.setLocationRelativeTo(null); // Centers the window on the screen

    // Intialize textField
    textfield = new JTextField();

    textfield.setFont(new Font("Calibri", Font.BOLD, 32)); // Set the font
    textfield.setBackground(Color.LIGHT_GRAY); // Set background color
    textfield.setForeground(Color.BLUE); // Set text color
    textfield.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Set black border with 2px thickness
    textfield.setHorizontalAlignment(JTextField.RIGHT); // Align text to the center
    textfield.setEditable(false); // Makes TextField Display Only

    // add text JTextfield to the frame
    frame.add(textfield, BorderLayout.NORTH);

    // Intialize the button panel with a grid layout
    buttonPanel = new JPanel();
    buttonPanel.setBounds(50, 100, 300, 300);
    buttonPanel.setLayout(new GridLayout(6, 4));

    // Initialize and add the buttons to the panel
    for (int i = 0; i < 10; i++) {
      numberButtons[i] = new JButton(String.valueOf(i)); // Create button with label i
      buttonPanel.add(numberButtons[i]); // Add button to the panel
    }
    // create operator buttons
    JButton addButton = new JButton("+");
    JButton subButton = new JButton("-");
    JButton divButton = new JButton("/");
    JButton mulButton = new JButton("*");
    JButton eqButton = new JButton("=");
    JButton decButton = new JButton(".");
    JButton delButton = new JButton("C");
    JButton negButton = new JButton("+-");
   

    // Intilialize Funtion Array
    functionButtons[0] = addButton;
    functionButtons[1] = subButton;
    functionButtons[2] = divButton;
    functionButtons[3] = mulButton;
    functionButtons[4] = eqButton;
    functionButtons[5] = decButton;
    functionButtons[6] = delButton;
    functionButtons[7] = negButton;



    // Rearrange buttons in a specific order
    buttonPanel.add(numberButtons[7]);
    buttonPanel.add(numberButtons[7]);
    buttonPanel.add(numberButtons[8]);
    buttonPanel.add(numberButtons[9]);
    buttonPanel.add(numberButtons[4]);
    buttonPanel.add(numberButtons[5]);
    buttonPanel.add(numberButtons[6]);
    buttonPanel.add(numberButtons[1]);
    buttonPanel.add(numberButtons[2]);
    buttonPanel.add(numberButtons[3]);
    buttonPanel.add(numberButtons[0]);

    // Add button to the frame
    frame.add(buttonPanel, BorderLayout.CENTER);

    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new calculator();
  }
}
