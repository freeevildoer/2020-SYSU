package gridworld_implentation;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class KingCrab extends CrabCritter{
	
    public void processActors(ArrayList<Actor> actors) {
        Grid gr = getGrid();
        int[] dirs =
            { Location.AHEAD, Location.HALF_LEFT, Location.HALF_RIGHT };
        for (Actor a : actors) {
        	for(int d : dirs) {
        		Location loc2 = a.getLocation().getAdjacentLocation(getDirection() + d);
        		if(gr.isValid(loc2) && gr.get(loc2) == null)
        			a.moveTo(loc2);
        		else
        			a.removeSelfFromGrid();
        		
        	}
        }
   }
}
