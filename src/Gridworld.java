import java.awt.Color;
import java.util.Random;

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
public class Gridworld {
	
	public static void main(String[] args) {
		Gridworld g = new Gridworld();
		g.addStuff();
	}
	void addStuff(){
		World w = new World();
		w.show();
		Location l1 = new Location(2,2);
		Bug b = new Bug();
		w.add(l1, b);
		Random r = new Random();
		Location l2 = new Location(r.nextInt(9), r.nextInt(9));
		Bug b2 = new Bug();
		b2.setColor(Color.BLUE);
		b2.turn();
		w.add(l2, b2);
		for (int i=0; i<200; i++) {
			Location l3 = new Location(r.nextInt(9), r.nextInt(9));
			Flower f2 = new Flower();
			f2.setColor(Color.BLUE);
			w.add(l3, f2);
		}
	}
}
