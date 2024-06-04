import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projektil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projektil extends Actor
{
    /**
     * Act - do whatever the Projektil wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private long lastAdded = System.currentTimeMillis();
    
    private int score;
    
    private Sound Musik;
    
    public void act() 
    {
       World world;
       world = getWorld();
       super.move(10);
       if(isTouching(Monster.class))
           {
               Spiel.score++;
               Musik = new Sound("Treffersound.wav");
               Musik.spielen();
           }
           
       if(isTouching(Hindernis.class)|isTouching(Monster.class))
       {
           super.removeTouching(Monster.class);
           world.removeObject(this);
       }
    }

}

