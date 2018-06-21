/*
 *    Copyright (c) The League of Amazing Programmers 2013-2017
 *    Level 1
 */



import java.applet.AudioClip;
import java.io.IOException;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class TimeBomb {
	/*
	 * This is an advanced recipe. There may be more than one line of code for
	 * each instruction.
	 * Work in seconds when testing, then change to minutes
	 */

	public static void main(String[] args) throws InterruptedException {
		String ts = JOptionPane.showInputDialog("Time till explosion? Milliseconds, please. MINIMUM 5000!");
		int t = Integer.parseInt(ts);
		TimeBomb c = new TimeBomb();
		c.setTime(t);
		c.start();
		

	}

	private int ms;

	public void setTime(int minutes) {
		this.ms = minutes;
		System.out.println("Bomb set to " + ms + " milliseconds.");
	}

	public void start() throws InterruptedException {
		Thread.sleep(ms-5000);
		speak("5");
		Thread.sleep(1000);
		speak("4");
		Thread.sleep(1000);
		speak("3");
		Thread.sleep(1000);
		speak("2");
		Thread.sleep(1000);
		speak("1");
		Thread.sleep(1000);
		playSound("boom.wav");
	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet
				.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

private void speak(String stuffToSay) {
		try {
			Runtime.getRuntime().exec("say " + stuffToSay).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

