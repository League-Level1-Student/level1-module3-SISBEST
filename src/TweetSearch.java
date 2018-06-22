import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.management.Query;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class TweetSearch implements ActionListener {
	JPanel p = new JPanel();
	JFrame f = new JFrame();
	JTextField tf = new JTextField(20);
	JButton b = new JButton();
	public static void main(String[] args) {
		TweetSearch t = new TweetSearch();
		t.createUI();
	}
	void createUI(){
		b.setText("Search Twitter");
		p.setVisible(true);
		f.setVisible(true);
		p.add(b);
		p.add(tf);
		f.add(p);
		f.pack();
		b.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton butt = (JButton) e.getSource();
		if (butt == b) {
			getLatestTweet(tf.getText());
		}
		
		
	}
	private String getLatestTweet(String searchingFor) {

	      Twitter twitter = new TwitterFactory().getInstance();

	      AccessToken accessToken = new AccessToken(
	            "2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
	            "vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");

	      twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN",
	            "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");

	      twitter.setOAuthAccessToken(accessToken);

	      Query query = new Query(searchingFor);
	      try {
	            QueryResult result = twitter.search(query);
	            return result.getTweets().get(0).getText();
	      } catch (Exception e) {
	            System.err.print(e.getMessage());
	            return "What the heck is that?";
	      }
	}
}
