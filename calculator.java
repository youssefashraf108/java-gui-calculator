import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator {
  JFrame frame;
  JPanel panel;
  JTextField textfield;
  JPanel buttonPanel;

  public calculator() {
    frame = new JFrame(" Crazy Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);

    frame.setLocationRelativeTo(null); // Centers the window on the screen

    textfield = new JTextField();

    textfield.setFont(new Font("Calibri", Font.BOLD, 32)); // Set the font
    textfield.setBackground(Color.LIGHT_GRAY); // Set background color
    textfield.setForeground(Color.BLUE); // Set text color
    textfield.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Set black border with 2px thickness
    textfield.setHorizontalAlignment(JTextField.RIGHT); // Align text to the center
    textfield.setEditable(false); // Makes TextField Display Only

    // add text JTextfield to the frame
    frame.add(textfield, BorderLayout.NORTH);

    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new calculator();
  }
}
