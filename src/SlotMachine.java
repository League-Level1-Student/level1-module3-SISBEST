import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import javax.swing.*;
import java.util.*;

public class SlotMachine implements ActionListener {
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton b = new JButton();
	int score;
	public static void main(String[] args) {
		SlotMachine sm = new SlotMachine();
		sm.LabelMachine();

	}
	void LabelMachine() {
		try {
			JLabel google = createLabelImage("google.png");
			JLabel apple = createLabelImage("Apple.jpeg");
			JLabel microsoft = createLabelImage("Microsoft.png");
			f.add(p);
			b.setText("SPIN!");
			b.setPreferredSize(new Dimension(500, 100));
			p.add(b);
			p.add(google);
			p.add(apple);
			p.add(microsoft);
			f.pack();
			f.setVisible(true);
			b.addActionListener(this);
		} catch (MalformedURLException e) {
			System.err.println("Aw. We didn't find that file.");
		}
	}
	private JLabel createLabelImage(String fileName) throws MalformedURLException {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}
	@SuppressWarnings("all")
	@Override
	public void actionPerformed(ActionEvent e) {
		Random r = new Random();
		int f1 = r.nextInt(3);
		int f2 = r.nextInt(3);
		int f3 = r.nextInt(3);
		p.removeAll();
		p.add(b);
		go(f1);
		go(f2);
		go(f3);
		f.pack();
		if(f1 == f2 && f2 == f3) {
			score++;
			System.out.println("Score: " + score);
		}
	}
	void go(int c) {
		if(c == 0) {
			try {
				JLabel newsomething = createLabelImage("google.png");
				p.add(newsomething);
			} catch (MalformedURLException e) {
				System.err.println("What the ******g **l* has happened?");
			}
		}
		if(c == 1) {
			try {
				JLabel newsomething = createLabelImage("Apple.jpeg");
				p.add(newsomething);
			} catch (MalformedURLException e) {
				System.err.println("What the ******g **l* has happened?");
			}
		}
		if(c == 2) {
			try {
				JLabel newsomething = createLabelImage("Microsoft.png");
				p.add(newsomething);
			} catch (MalformedURLException e) {
				System.err.println("What the ******g **l* has happened?");
			}
		}
	}
}