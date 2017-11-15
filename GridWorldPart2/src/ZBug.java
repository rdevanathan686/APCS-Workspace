

/**
 * A <code>ZBug</code> creates a Z shape of a given size
 */
public class ZBug extends BoxBug
{
    private int side;

    /**
     * Constructs a circle bug that traces a Z pattern of a given length
     * @param length the side length
     */
    public ZBug(int length)
    {
        super(length);
        side = 1;
        this.setDirection(90);
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (side <= 3)
            super.move();
    }
    
    public void turn()
    {
        if (side == 1)
            this.setDirection(getDirection() + 135);
        else if (side == 2)
            this.setDirection(getDirection() - 45); 
        else if (side == 3)
            this.setDirection(90);
        
        side++;
    }
}
