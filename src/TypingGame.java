import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TypingGame implements KeyListener {
	JLabel l = new JLabel();
	JFrame f = new JFrame();
	int c = 0;
	Date timeAtStart = new Date();
	char currentLetter;
	public static void main(String[] args) {
		TypingGame t = new TypingGame();
		System.out.println("Welcome to TypingTutor by S! We print out your Typing Speed every 10 keys. After 10 keys the typing speed is Reset.");
		t.UI();
	}
	char generateRandomLetter() {
	      Random r = new Random();
	      return (char) (r.nextInt(26) + 'a');
	}
	void UI(){
		l.setFont(l.getFont().deriveFont(28.0f));
		l.setHorizontalAlignment(JLabel.CENTER);
		currentLetter = generateRandomLetter();
		l.setText(currentLetter + " is the letter you need to type!");
		f.setVisible(true);
		f.addKeyListener(this);
		f.add(l);
		f.pack();
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		if (key == currentLetter) {
			f.setBackground(Color.GREEN);
			System.out.println("Yay!");
			currentLetter = generateRandomLetter();
			l.setText(currentLetter + " is the letter you need to type!");
			c++;
			if(c == 10){
				showTypingSpeed(c);
				System.out.println("Checked typeSpeed. Resetting int c and Date timeAtStart to init. (In other words, restarting TypeTracking!)");
				c = 0;
				timeAtStart = new Date();
			}
}
		else {
			System.out.println("BOO. You lose!");
			System.exit(10);
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	private void showTypingSpeed(int numberOfCorrectCharactersTyped) {
	      Date timeAtEnd = new Date();
	      long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
	      long gameInSeconds = (gameDuration / 1000) % 60;
	      double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
	      int charactersPerMinute = (int) (charactersPerSecond * 60);
	      JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute.");
	}
}
