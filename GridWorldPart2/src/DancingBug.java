import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
    private int[] turns;
    private int currentTurn = 0;
    
    public DancingBug (int[] turns)
    {
        this.turns = turns;
    }
    
    public void act()
    {
        for (int i = 0; i < turns[currentTurn]; i++)
        {
            turn();
        }
        
        super.act();
        
        if (currentTurn < turns.length - 1)
            currentTurn++;
        else
            currentTurn = 0;
    }
    
}
