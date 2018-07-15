import javax.swing.*;

public class WhackAMole {
JFrame f = new JFrame();
JPanel p = new JPanel();
public static void main(String[] args) {
	
}
void drawButtons(int rnd) {
	for(int i = 0; i<24; i++) {
		JButton b = new JButton();
		if(rnd == i) {
			b.setText("MOLE!!!");
		}
	}
}
}
