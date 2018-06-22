import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import info.gridworld.world.World;
public class Gridworld {
	World w = new World();
	public static void main(String[] args) {
		Gridworld g = new Gridworld();
		g.addStuff();
	}
	void addStuff(){
		Location l1 = new Location(2,2);
		Bug b = new Bug();
	}
}
