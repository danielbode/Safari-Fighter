import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Actor
{
    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private long lastAdded = System.currentTimeMillis();
    
    public void act() 
    {
        move(4);
        collide();        
    }    
    
    public void collide()
    {
        int direction = getRotation();
        switch(direction)
        {
            case 0:  try
                     {
                        if(super.getOneObjectAtOffset(35,0,Obstacle.class).getX()>super.getX())
                        {
                            RTurn();
                        }
                        else
                        {}
                     } 
                     catch (NullPointerException e) 
                     {}
                     break;
            case 90: try
                     {
                        if(super.getOneObjectAtOffset(0,35,Obstacle.class).getY()>super.getY())
                        {
                            RTurn();
                        }
                        else
                        {}
                     }
                     catch (NullPointerException e)
                     {}
                     break;
            case 180:try
                    {
                        if(super.getOneObjectAtOffset(-35,0,Obstacle.class).getX()<super.getX())
                        {
                            RTurn();
                        }
                        else
                        {}
                    }
                    catch (NullPointerException e)
                    {}
                    break;
            case 270:try
                    {
                        if(super.getOneObjectAtOffset(0, -35, Obstacle.class).getY()<super.getY())
                        {
                            RTurn();
                        }
                        else
                        {}
                    }
                    catch (NullPointerException e)
                    {}
                    break;
        }
    }
    
    public void RTurn()
    {
        turn((greenfoot.Greenfoot.getRandomNumber(3)+1)*90);
    }
}
