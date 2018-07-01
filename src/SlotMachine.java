import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

public class SlotMachine {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		SlotMachine sm = new SlotMachine();
		sm.LabelMachine();
		

	}
	void LabelMachine() {
		try {
			JLabel google = createLabelImage("google.png");
			JLabel apple = createLabelImage("Apple.jpeg");
			JLabel microsoft = createLabelImage("Microsoft.png");
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
}
