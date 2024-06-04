import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private long lastAdded = System.currentTimeMillis();
    
    private int score;
    
    private Sound music;
    
    public void act() 
    {
       World world;
       world = getWorld();
       super.move(10);
       if(isTouching(Monster.class))
           {
               Game.score++;
               music = new Sound("Treffersound.wav");
               music.spielen();
           }
           
       if(isTouching(Obstacle.class)|isTouching(Monster.class))
       {
           super.removeTouching(Monster.class);
           world.removeObject(this);
       }
    }

}

