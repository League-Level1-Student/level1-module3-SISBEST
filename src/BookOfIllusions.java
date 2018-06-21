
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
/** We’re going to make a slideshow of cool optical illusions. When the user clicks on an illusion, a new one will be loaded. **/

public class BookOfIllusions extends MouseAdapter {

	/*
	 * Here we are instantiating our BookOfIllusions class and calling it’s createBook() method. This is because we want to get out of the
	 * static main method, so that we can add a click listener to each illusion.
	 */
	String a = "optical.jpg";
	String b = "illusion.jpg";
	JLabel l;
	public static void main(String[] args) throws Exception {
		BookOfIllusions illusions = new BookOfIllusions();
		illusions.createBook();
	}

	JFrame f = new JFrame();

	private void createBook() {
		
		f.setVisible(true);
		f.pack();
		l = loadImageFromComputer(a);
		l.setVisible(true);
		f.add(l);
		f.pack();
		f.addMouseListener(this);
	}

	public void mousePressed(MouseEvent e) {
		l.setVisible(false);;
		System.out.println("Clicked!");
		l = loadImageFromComputer(b);
		l.setVisible(true);
		f.add(l);
		f.pack();
	}
	public JLabel loadImageFromComputer(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

}