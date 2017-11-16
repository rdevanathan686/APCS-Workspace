import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bug and circle bugs <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class DancingBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        int[] turns = new int[]{1, 2, 2, 3, 3, 2, 2, 1};
        DancingBug alice = new DancingBug(turns); 
        alice.setColor(Color.ORANGE);
        world.add(new Location(5, 5), alice);
        world.show();
    }
}