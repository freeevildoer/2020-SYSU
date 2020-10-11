package Cac;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cac {
	public static void main(String[] args) {
		new MyFrame("Calculator");
	}

}

class MyFrame extends Frame {
	public TextArea textarea;
	
	public MyFrame(String name) {
		super(name);
		SetTextAreas();
		SetButtonArea();
		SetMainFram();
	}

	private void SetButtonArea() {

		addButton("7", 45, 45, 30, 130);
		addButton("8", 45, 45, 75, 130);
		addButton("9", 45, 45, 120, 130);
		addButton("/", 45, 45, 165, 130);

		addButton("4", 45, 45, 30, 175);
		addButton("5", 45, 45, 75, 175);
		addButton("6", 45, 45, 120, 175);
		addButton("*", 45, 45, 165, 175);
	
		addButton("1", 45, 45, 30, 220);
		addButton("2", 45, 45, 75, 220);
		addButton("3", 45, 45, 120, 220);
		addButton("-", 45, 45, 165, 220);

		addButton("0", 45, 45, 30, 265);
		addButton(".", 45, 45, 75,265);
		addButton("=", 45, 45, 165, 265);
		addButton("+", 45, 45, 120, 265);
		addButton("c",180,45,30,310);
	}

	double num1, num2;
	String s;
	boolean flag = true;
	boolean flag2 = false;

	private void addButton(String string, int i, int j, int x, int y) {
		final Button b = new Button(string);
		b.setSize(i, j);
		b.setLocation(x, y);
		b.setFont(new Font("", Font.PLAIN, 15));
		b.setBackground(Color.gray);
		b.setForeground(Color.BLUE);
		b.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				counts();
			}

			private void counts() {
				if (textarea.getText().equals("") && (b.getActionCommand().equals("+") || b.getActionCommand().equals("-") || b.getActionCommand().equals("*") || b.getActionCommand().equals("/") || b.getActionCommand().equals("="))) {

				} 
				else if (textarea.getText().equals(".") && (b.getActionCommand().equals("+") || b.getActionCommand().equals("-") || b.getActionCommand().equals("*")|| b.getActionCommand().equals("/") || b.getActionCommand().equals("="))) {

				} 
				else {
					if(b.getActionCommand().equals("+") || b.getActionCommand().equals("-") || b.getActionCommand().equals("*") || b.getActionCommand().equals("/")) {
						if(flag2 = true){
							flag2 = false;
						}
						if(flag){
							num2 = new Double(textarea.getText()).doubleValue();
							flag = false;
						} 
						else{
							if (s == "=") {
							} 
							else{
								num1 = new Double(textarea.getText()).doubleValue();
								if (s == "-"){
									if (num2 == 0)
										num2 = num1;
									else
										num2 = num2 - num1;
								} else if (s == "+") {
									if (num2 == 0)
										num2 = num1;
									else
										num2 = num2 + num1;
								} else if (s == "*") {
									if (num2 == 0)
										num2 = num1;
									else
										num2 = num2 * num1;
								} 
								 else if (s == "/") {
									if (num2 == 0)
										num2 = num1;
									else
										num2 = num2 / num1;
								}
							}
						}
						s = b.getActionCommand();
						textarea.setText("");
					} 
					else if (b.getActionCommand().equals("=")) {
						num1 = new Double(textarea.getText()).doubleValue();
						if (s == "+"){
							textarea.setText("");
							textarea.append(num2 + "+" + num1);
							textarea.append(System.getProperty("line.separator"));
							num2 = num2 + num1;
							textarea.append("=" + num2);
						} 
						else if(s == "-"){
							textarea.setText("");
							textarea.append(num2 + "-" + num1);
							textarea.append(System.getProperty("line.separator"));
							num2 = num2 - num1;
							textarea.append("=" + num2);
						} 
						else if(s == "*"){
							textarea.setText("");
							textarea.append(num2 + "*" + num1);
							textarea.append(System.getProperty("line.separator"));
							num2 = num2 * num1;
							textarea.append("=" + num2);
						} 
						else if(s == "/"){
							textarea.setText("");
							textarea.append(num2 + "/" + num1);
							textarea.append(System.getProperty("line.separator"));
							num2 = num2 / num1;
							textarea.append("=" + num2);
						}
						s = "=";
						flag2 = true;
					} 
					else if(b.getActionCommand().equals("c")){
						num1 = num2 = 0;
						textarea.setText("");
					}
				}
			}
		});
		this.add(b);
	}

	private void SetTextAreas() {
		textarea = new TextArea("", 8, 20, 3);
		textarea.setBackground(Color.white);
		textarea.setSize(210, 60);
		textarea.setFont(new Font("",Font.PLAIN,15));
		textarea.setLocation(17, 60);
		this.add(textarea);

	}

	private void SetMainFram() {
		this.setLayout(null);
		this.setSize(230, 360);
		this.setVisible(true);
		this.setLocation(500, 450);
		this.setResizable(false);
		textarea.setEditable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

}
