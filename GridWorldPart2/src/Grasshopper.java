/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;



/**
 * A <code>Grasshopper</code> is an actor that can move and turn. 
 * It drops flowers as it moves and hops over the rock.<br />
 */
public class Grasshopper extends Actor
{
   private Color initialColor;
   private boolean previousMove = false;
   private final Color PURPLE_COLOR = new Color(148,0,211);
   /**
    * Constructs a green grasshopper.
    */
   public Grasshopper()
   {
      initialColor = Color.GREEN;
      setColor(initialColor);
   }

   /**
    * Constructs a grasshopper of a given color.
    * @param grasshoperColor the color for this bug
    */
   public Grasshopper(Color grasshopperColor)
   {
      initialColor = grasshopperColor;
      setColor(initialColor);
   }
   /**
    * Moves if it can move, turns otherwise.
    */
   public void act()
   {
    
      if (canMove())
      {
         move();
         
         if (previousMove)
         {
            setColor(initialColor);
            previousMove = false;
         }
         
      }
      
      else
      {
         if (checkActor() instanceof Rock 
               && getGrid().isValid(checkActor().getLocation().getAdjacentLocation(getDirection())))
               jump();
         else
         {
            turn();
            turn();
            
            if (!previousMove)
            {
               initialColor = getColor();
               setColor(PURPLE_COLOR);
               previousMove = true;
               
            }
         }
      }

   }
   
   /**
    * Turns the bug 45 degrees to the right without changing its location.
    */
   public void turn()
   {
      setDirection(getDirection() + Location.HALF_RIGHT);
   }

   /**
    * Moves the grasshopper forward, putting a flower into the location it previously
    * occupied.
    */
   public void move()
   {
      Grid<Actor> gr = getGrid();
      if (gr == null)
         return;
      Location loc = getLocation();
      Location next = loc.getAdjacentLocation(getDirection());
      if (gr.isValid(next))
         moveTo(next);
      else
         removeSelfFromGrid();
      Flower flower = new Flower(getColor());
      flower.putSelfInGrid(gr, loc);
   }
   
   /**
    * Moves the grasshopper forward two steps, putting a flower into the location it previously
    * occupied.
    */
   public void jump()
   {
      Grid<Actor> gr = getGrid();
      if (gr == null)
         return;
      Location loc = getLocation();
      Location next = loc.getAdjacentLocation(getDirection());
      
      if (getDirection() == Location.SOUTH)
         moveTo(new Location (getLocation().getRow() + 2, getLocation().getCol()));
      else if (getDirection() == Location.NORTH)
         moveTo(new Location (getLocation().getRow() - 2, getLocation().getCol()));
      else if (getDirection() == Location.EAST)
         moveTo(new Location (getLocation().getRow(), getLocation().getCol() + 2));
      else 
         moveTo(new Location (getLocation().getRow(), getLocation().getCol() - 2));
      
      Flower flower = new Flower(getColor());
      flower.putSelfInGrid(gr, loc);
   }

   /**
    * Tests whether this grasshopper can move forward into a location 
    * that is empty or contains a flower.
    * @return true if this grasshopper can move.
    */
   public boolean canMove()
   {
      Grid<Actor> gr = getGrid();
      
      if (gr == null)
         return false;
      
      Location loc = getLocation();
      Location next = loc.getAdjacentLocation(getDirection());
      
      if (!gr.isValid(next))
         return false;
      
      Actor neighbor = gr.get(next);
      return (neighbor == null) || (neighbor instanceof Flower);
      
   }
   
   /**
    * Checks for the adjacent block and returns the type of object it found 
    */
   private Actor checkActor()
   {
      Grid<Actor> gr = getGrid();

      if (gr == null)
         return null;
      
      Location loc = getLocation();
      Location next = loc.getAdjacentLocation(getDirection());
      
      if (!gr.isValid(next))
         return null;
      
      Actor neighbor = gr.get(next);
      return neighbor;

   }
   
}
