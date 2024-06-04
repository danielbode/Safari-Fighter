import greenfoot.*;

/**
 * Write a description of class Startbildschirm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Startbildschirm extends Actor
{
    /**
     * Act - do whatever the Startbildschirm wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }
    
    public void scale(int x,int y)
    {
        GreenfootImage start = new GreenfootImage("01_startscreen.png");
        start.scale(x,y);
        start.drawImage(start, x,y);
    }
}
