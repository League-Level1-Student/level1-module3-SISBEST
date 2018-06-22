import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import javax.swing.*;
public class NastySurprise implements ActionListener {
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton trick = new JButton();
	JButton treat = new JButton();
	public static void main(String[] args) {
		NastySurprise n = new NastySurprise();
		n.UI();
	}
	void UI() {
		p.add(trick);
		p.add(treat);
		f.add(p);
		trick.setText("Trick");
		treat.setText("or Treat!");
		trick.addActionListener(this);
		treat.addActionListener(this);
		f.setVisible(true);
		f.pack();
	}
	private void i(String imageUrl) {
	     try {
	          URL url = new URL(imageUrl);
	          Icon icon = new ImageIcon(url);
	          JLabel imageLabel = new JLabel(icon);
	          JFrame frame = new JFrame();
	          frame.add(imageLabel);
	          frame.setVisible(true);
	          frame.pack();
	     } catch (MalformedURLException e) {
	          e.printStackTrace();
	     }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton butt = (JButton) e.getSource();
		if(butt == trick) {
			i("https://image.shutterstock.com/image-vector/fantasy-scary-smiling-cat-face-260nw-718651006.jpg");
		}
		if(butt == treat) {
			i("https://www.mythirtyspot.com/wp-content/uploads/2014/09/Screen-Shot-2014-09-18-at-10.19.29-PM-1024x712.png");
		}
	}
}