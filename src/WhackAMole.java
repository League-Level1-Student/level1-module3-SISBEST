import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.*;

public class WhackAMole implements ActionListener {
JFrame f = new JFrame();
JPanel p = new JPanel();
Date timeAtStart = new Date();
int score;
public static void main(String[] args) {
	WhackAMole w = new WhackAMole();
	Random b = new Random();
	int r = b.nextInt(23);
	w.drawButtons(r);
}
void drawButtons(int rnd) {
	for(int i = 0; i<24; i++) {
		JButton b = new JButton();
		p.add(b);
		f.add(p);
		f.setSize(523, 596);
		f.setVisible(true);
		b.addActionListener(this);
		if(rnd == i) {
			b.setText("MOLE!!!");
		}
	}
}
@Override
public void actionPerformed(ActionEvent e) {
	JButton beep = (JButton) e.getSource();
	if(!(beep.getText().equals("MOLE!!!"))){
		speak("NO! Score is "+ score);
	score--;
	}
	else {
		score++;
		speak("YES! Score is "+ score);
	}
	f.remove(p);
	p = new JPanel();
	Random r = new Random();
	drawButtons(r.nextInt(23));
	
	if (score == 10) {
		endGame(timeAtStart, score);
	}
	else if (score == -5) {
		System.err.println("You Lose!");
		System.exit(1);
	}
}
void speak(String words) {
    try {
         Runtime.getRuntime().exec("say " + words).waitFor();
    } catch (Exception e) {
         e.printStackTrace();
    }
}
private void endGame(Date timeAtStart, int molesWhacked) {
    Date timeAtEnd = new Date();
    JOptionPane.showMessageDialog(null, "Your whack rate is "
         + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
         + " moles per second.");
}
}
