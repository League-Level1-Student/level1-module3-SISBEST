import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Calculator implements ActionListener {
	JTextField tf1 = new JTextField(20);
	JTextField tf2 = new JTextField(20);
	JButton add = new JButton();
	JButton substract = new JButton();
	JButton multiply = new JButton();
	JButton divide = new JButton();
	JPanel p = new JPanel();
	JFrame f = new JFrame();
	JLabel l = new JLabel();
	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.UI();
	}
	void UI() {
		add.addActionListener(this);
		add.setText("+");
		substract.addActionListener(this);
		substract.setText("-");
		multiply.addActionListener(this);
		multiply.setText("*");
		divide.addActionListener(this);
		divide.setText("/");
		p.add(add);
		p.add(substract);
		p.add(multiply);
		p.add(divide);
		p.add(tf1);
		p.add(tf2);
		p.add(l);
		f.add(p);
		f.setVisible(true);
		f.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if(b.equals(add)) {
			int tfi1 = Integer.parseInt(tf1.getText());
			int tfi2 = Integer.parseInt(tf2.getText());
			l.setText(tfi1 + tfi2 + " is the answer!");
			f.pack();
		}
		if(b.equals(substract)) {
			int tfi1 = Integer.parseInt(tf1.getText());
			int tfi2 = Integer.parseInt(tf2.getText());
			l.setText(tfi1 - tfi2 + " is the answer!");
			f.pack();
		}
		if(b.equals(multiply)) {
			int tfi1 = Integer.parseInt(tf1.getText());
			int tfi2 = Integer.parseInt(tf2.getText());
			l.setText(tfi1 * tfi2 + " is the answer!");
			f.pack();
		}
		if(b.equals(divide)) {
			int tfi1 = Integer.parseInt(tf1.getText());
			int tfi2 = Integer.parseInt(tf2.getText());
			l.setText(tfi1 / tfi2 + " is the answer!");
			f.pack();
		}
	}

}
