package Cac;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
public class Cac2 extends JFrame{
	  private JButton operator, equal, result, add, subtract, multiply, divide, ok;
	  private JTextField num1, num2;
	  
	  private void addOperatorListeners() {
	    add.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        operator.setText("+");
	      }
	    });
	    
	    subtract.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        operator.setText("-");
	      }
	    });

	    multiply.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        operator.setText("*");
	      }
	    });

	    divide.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        operator.setText("/");
	      }
	    });
	  }

	  private void addButtonListeners() {
	    ok.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        double Result;
	        double Num1 = Double.parseDouble(num1.getText());
	        double Num2 = Double.parseDouble(num2.getText());
	        String Operator = operator.getText();
	        if (Operator.equals("+")) {
	          Result = Num1 + Num2;
	        } 
	        else if (Operator.equals("-")) {
	          Result = Num1 - Num2;
	        } 
	        else if (Operator.equals("*")) {
	          Result = Num1 * Num2;
	        } 
	        else {
	          Result = Num1 / Num2;
	        }
	        result.setText(Result + "");
	      }
	    });
	  }

	  private void addKeyListeners() {
	    num1.addKeyListener(new KeyAdapter() {
	      public void keyTyped(KeyEvent e) {
	        int keyChar = e.getKeyChar();
	        if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {
	          return;
	        }
	        else {
	          e.consume();
	        }
	      }
	    });
	    num2.addKeyListener(new KeyAdapter() {
	      public void keyTyped(KeyEvent e) {
	        int keyChar = e.getKeyChar();
	        if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {
	          return;
	        }
	        else {
	          e.consume();
	        }
	      }
	    });
	  }

	  public Cac2() {
	    setLayout(new GridLayout(2, 5));
	    num1 = new JTextField(5);
	    num2 = new JTextField(5);
	    Font font = new Font("",Font.PLAIN,20);
	    num1.setFont(font);
	    num2.setFont(font);
	    add = new JButton("+");
	    subtract = new JButton("-");
	    multiply = new JButton("*");
	    divide = new JButton("/");
	    operator = new JButton("");
	    equal = new JButton("=");
	    result = new JButton("");
	    ok = new JButton("OK");
	    add.setFont(font);
	    subtract.setFont(font);
	    multiply.setFont(font);
	    divide.setFont(font);
	    operator.setFont(font);
	    operator.setEnabled(false);
	    equal.setEnabled(false);
	    result.setEnabled(false);
	    add(num1);
	    add(operator);
	    add(num2);
	    add(equal);
	    add(result);
	    add(add);
	    add(subtract);
	    add(multiply);
	    add(divide);
	    add(ok);
	    addOperatorListeners();
	    addButtonListeners();
	    addKeyListeners();
	  }

	  public static void main(String[] args) {
	    Cac2 calculator= new Cac2();
	    calculator.setSize(500, 400);
	    calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    calculator.setVisible(true);
	  }
	
}
	
