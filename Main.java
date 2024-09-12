import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
  static void myMethod() {
    JFrame frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();

    // size the frame
    frame.setSize(600, 600);
    frame.setVisible(true);

  }

  public static void main(String[] args) {
    myMethod();
  }
}
