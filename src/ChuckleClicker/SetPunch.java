package ChuckleClicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SetPunch implements ActionListener {
	JFrame f = new JFrame();
	JPanel pn = new JPanel();
	JTextField j = new JTextField(20);
	JLabel jl = new JLabel();
	JTextField p = new JTextField(20);
	JLabel pl = new JLabel();
	JButton b = new JButton();
	void set() {
		f.add(pn);
		jl.setText("Enter A Joke!");
		pn.add(jl);
		pn.add(j);
		pl.setText("Enter A Punchline!");
		pn.add(pl);
		pn.add(p);
		pn.add(b);
		b.setText("GOOOOOOOO!");
		f.pack();
		f.setVisible(true);	
		b.addActionListener(this);
	}
	String r1() {
		return j.getText();
	}
	String r2() {
		return p.getText();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		CCD chuckle = new CCD();
		String joke = r1();
		String punch = r2();
		chuckle.set(joke, punch);
		chuckle.UI();	
	}
}
