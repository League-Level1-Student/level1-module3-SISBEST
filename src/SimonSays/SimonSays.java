package SimonSays;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SimonSays implements ActionListener {
	Easy e = new Easy();
	Regular r = new Regular();
	Hard h = new Hard();
	INSANE i = new INSANE();
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton easy = new JButton("Easy (5 Lives)");
	JButton regular = new JButton("Regular (3 Lives)");
	JButton hard = new JButton("Hard (1 Life)");
	JButton insane = new JButton("INSANE (1 Life, TIMED)");
	public static void main(String[] args) {
		SimonSays ss = new SimonSays();
		ss.UI();
	}

	private void UI() {
		p.add(easy);
		p.add(regular);
		p.add(hard);
		p.add(insane);
		easy.addActionListener(this);
		regular.addActionListener(this);
		hard.addActionListener(this);
		insane.addActionListener(this);
		f.add(p);
		f.setVisible(true);
		f.pack();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton bp = (JButton) ae.getSource();
		if (bp == easy) {
			try {
				e.start();
			} catch (Exception e) {
				System.err.println("WHAT THE [CENSORED] IS THIS [CENSORED] ERROR?!!!!??????!!?!??!?!?!?!??!?!??! Actually, it's just:");
				e.printStackTrace();
			}
		}
		else if (bp == regular) {
			try {
				r.start();
			} catch (Exception e) {
				System.err.println("WHAT THE [CENSORED] IS THIS [CENSORED] ERROR?!!!!??????!!?!??!?!?!?!??!?!??! Actually, it's just:");
				e.printStackTrace();
			}
		}
		else if (bp == hard) {
			try {
				h.start();
			} catch (Exception e) {
				System.err.println("WHAT THE [CENSORED] IS THIS [CENSORED] ERROR?!!!!??????!!?!??!?!?!?!??!?!??! Actually, it's just:");
				e.printStackTrace();
			}
		}
		else if (bp == insane) {
			try {
				i.start();
			} catch (Exception e) {
				System.err.println("WHAT THE [CENSORED] IS THIS [CENSORED] ERROR?!!!!??????!!?!??!?!?!?!??!?!??! Actually, it's just:");
				e.printStackTrace();
			}
		}
		
	}

}
