package gridworld_implentation;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;

public class BlusterCritterRunner {
	  public static void main(String[] args) {
	    ActorWorld world = new ActorWorld();
	    BlusterCritter alice = new BlusterCritter(5);
	    BlusterCritter bob = new BlusterCritter(2);
	    bob.setColor(Color.BLUE);
	    Bug bug1 = new Bug();
	    bug1.setColor(Color.YELLOW);
	    Bug bug2 = new Bug();
	    bug2.setColor(Color.PINK);
	    Rock rock1 = new Rock();
	    Rock rock2 = new Rock();
	    Rock rock3 = new Rock();
	    world.add(new Location(3, 2), alice);
	    world.add(new Location(2, 2), bug1);
	    world.add(new Location(4, 2), bug2);
	    world.add(new Location(5, 5), bob);
	    world.add(new Location(5, 6), rock1);
	    world.add(new Location(5, 4), rock2);
	    world.add(new Location(4, 5), rock3);
	    world.show();
	  }
	}