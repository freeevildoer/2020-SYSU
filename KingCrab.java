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
        Location loc = getLocation();
//        for (Actor a : actors) {
//        	for(int d : dirs) {
//        		Location loc2 = a.getLocation().getAdjacentLocation(getDirection() + d);
//        		if(gr.isValid(loc2) && gr.get(loc2) == null)
//        			a.moveTo(loc2);
//        		else
//        			a.removeSelfFromGrid();
//        		
//        	}
//        }
        for (Actor a : actors) {
            if (a.getLocation().equals(loc.getAdjacentLocation(getDirection() + dirs[0]))) {
                Location tmp = a.getLocation().getAdjacentLocation(getDirection() + dirs[0]);
                if(gr.isValid(tmp) && gr.get(tmp) == null) {
                   a.moveTo(tmp);
                 } else {
                   a.removeSelfFromGrid();
                 }
             } else if (a.getLocation().equals(loc.getAdjacentLocation(getDirection() + dirs[1]))) {

                Location tmp = a.getLocation().getAdjacentLocation(getDirection() + dirs[1]);
                if(gr.isValid(tmp) && gr.get(tmp) == null) {
                   a.moveTo(tmp);
                 } else {
                   a.removeSelfFromGrid();
                 }
             } else if (a.getLocation().equals(loc.getAdjacentLocation(getDirection() + dirs[2]))) {
                Location tmp = a.getLocation().getAdjacentLocation(getDirection() + dirs[2]);
                if(gr.isValid(tmp) && gr.get(tmp) == null) {
                   a.moveTo(tmp);
                 } else {
                   a.removeSelfFromGrid();
                 }
             }  
         }
   }
}
