
public class Netflix {

	public static void main(String[] args) {
		Movie m = new Movie("BEEP!", 3);
		Movie t = new Movie("YEE!", 1);
		Movie w = new Movie("A Beep At Twilight", 100);
		Movie s = new Movie("LIFE BEEP!", 2);
		Movie b = new Movie("Mommy liked to beep!", 106);
		System.out.println("A Beep At Twilight: " + w.getTicketPrice());
		System.out.println("LIFE BEEP!: " + s.getTicketPrice());
		System.out.println("The rest: " + b.getTicketPrice());
		NetflixQueue q = new NetflixQueue();
		q.addMovie(m);
		q.addMovie(t);
		q.addMovie(w);
		q.addMovie(s);
		q.addMovie(b);
		q.sortMoviesByRating();
		System.out.println("The best movie is " + q.getBestMovie());
		System.out.println("And in second place... " + q.getMovie(2));
	}

}
