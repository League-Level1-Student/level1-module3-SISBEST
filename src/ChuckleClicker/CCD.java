package ChuckleClicker;

import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CCD implements ActionListener {
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton joke = new JButton();
	JButton punch = new JButton();
	String jo;
	String pu;
		void UI(){
			p.add(joke);
			p.add(punch);
			joke.addActionListener(this);
			punch.addActionListener(this);
			joke.setPreferredSize(new Dimension(1000,500));
			punch.setPreferredSize(new Dimension(1000,500));
			f.pack();
		}
		void set(String j, String p) {
			joke.setText("JOKE");
			punch.setText("PUNCHLINE");
			jo = j;
			pu = p;
			f.add(this.p);
			f.setVisible(true);
			f.pack();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == joke) {
				playSound("laugh.wav");
				JOptionPane.showMessageDialog(null, jo);
			}
			else if(e.getSource() == punch) {
				playSound("laugh.wav");
				JOptionPane.showMessageDialog(null, pu);
			}
		}
		private void playSound(String fileName) {
			AudioClip scream = JApplet.newAudioClip(getClass().getResource(fileName));
			scream.play();
		}
}
