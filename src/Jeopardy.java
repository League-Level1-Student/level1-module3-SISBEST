import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;

/* This recipe is to be used with the Jeopardy Handout: http://bit.ly/1bvnvd4 */

public class Jeopardy implements ActionListener {
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton, fourthButton;
	
	private JPanel quizPanel;
	int score = 0;
	JLabel scoreBox = new JLabel("0");
	int buttonCount = 0;

	public static void main(String[] args) {
		new Jeopardy().start();
	}

	private void start() {
		playSound("jeopardy.wav");
		JFrame frame = new JFrame();
		quizPanel = new JPanel();
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setTitle("Samuel Jeopardy!");
		JPanel p = createHeader("Java");
		quizPanel.add(p);
		frame.add(quizPanel);
		JButton firstButton = createButton("$100");
		JButton secondButton = createButton("$200");
		JButton thirdButton = createButton("$400");
		JButton fourthButton = createButton("$600");
		quizPanel.add(firstButton);
		firstButton.addActionListener(this);
		quizPanel.add(secondButton);
		secondButton.addActionListener(this);
		quizPanel.add(thirdButton);
		thirdButton.addActionListener(this);
		quizPanel.add(fourthButton);
		fourthButton.addActionListener(this);
		frame.pack();
		quizPanel.setLayout(new GridLayout(buttonCount+1, 3));
		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height, Toolkit.getDefaultToolkit().getScreenSize().width);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private JButton createButton(String dollarAmount) {
		JButton b = new JButton();
		b.setText(dollarAmount);
		buttonCount++;
		return b;
	}

	public void actionPerformed(ActionEvent arg0) {
		playSound("jeopardy.wav");

		JButton buttonPressed = (JButton) arg0.getSource();
		if (buttonPressed == firstButton) {
			askQuestion("The Method For This Dialog", "JOptionPane.showMessageDialog(, )", 100);
		}
		if (buttonPressed == secondButton) {
			askQuestion("Lets you select a file", "JFileChooser", 200);
		}

		
	}

	private void askQuestion(String question, String correctAnswer, int prizeMoney) {
		String answer = JOptionPane.showInputDialog(question);
		if (answer == correctAnswer) {
			score = score + prizeMoney;
			updateScore();
		}
		else {
			score = score - prizeMoney;
			JOptionPane.showMessageDialog(null, "NOPE! It was " + correctAnswer + " !");
		}
			
		
	}
	private void playSound(String fileName) {
		AudioClip scream = JApplet.newAudioClip(getClass().getResource(fileName));
		scream.play();
	}

	private Component makeScorePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("score:"));
		panel.add(scoreBox);
		panel.setBackground(Color.CYAN);
		return panel;
	}

	private void updateScore() {
		scoreBox.setText("" + score);
	}

	private JPanel createHeader(String topicName) {
		JPanel panelj = new JPanel();
		panelj.setLayout(new BoxLayout(panelj, BoxLayout.PAGE_AXIS));
		JLabel l1 = new JLabel(topicName);
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelj.add(l1);
		return panelj;
	}

	void showCorrectImage() {
		showImage("correct.jpg");
	}

	void showIncorrectImage() {
		showImage("incorrect.jpg");
	}

	private void showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		frame.add(image);
		frame.setVisible(true);
		frame.pack();
	}
}
