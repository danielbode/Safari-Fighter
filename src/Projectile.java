import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Daniel Bode
 * @version 2024.06.04
 */
public class Projectile extends Actor {
    private long lastAdded = System.currentTimeMillis();
    
    private int score;
    
    private Sound music;
    
    public void act() {
       World world;
       world = getWorld();
       super.move(10);
       if (isTouching(Monster.class)) {
           Game.score++;
           music = new Sound("hit.wav");
           music.play();
       }
           
       if (isTouching(Obstacle.class)|isTouching(Monster.class)) {
           super.removeTouching(Monster.class);
           world.removeObject(this);
       }
    }
}
