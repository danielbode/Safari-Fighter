import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Daniel Bode
 * @version 2024.06.04
 */
public class Monster extends Actor {
    private long lastAdded = System.currentTimeMillis();
    
    public void act() {
        move(4);
        collide();
    }    
    
    public void collide() {
        int direction = getRotation();
        
        switch(direction) {
            case 0:
                try {
                    if (super.getOneObjectAtOffset(35,0,Obstacle.class).getX() > super.getX()) {
                        turnRight();
                    } else {}
                } 
                catch (NullPointerException e) {}
                break;
            case 90:
                try {
                    if(super.getOneObjectAtOffset(0,35,Obstacle.class).getY() > super.getY()) {
                        turnRight();
                    } else {}
                }
                catch (NullPointerException e) {}
                break;
            case 180:
                try {
                    if(super.getOneObjectAtOffset(-35,0,Obstacle.class).getX() < super.getX()) {
                        turnRight();
                    } else {}
                }
                catch (NullPointerException e) {}
                break;
            case 270:
                try {
                    if(super.getOneObjectAtOffset(0, -35, Obstacle.class).getY() < super.getY())
                    {
                        turnRight();
                    } else {}
                }
                catch (NullPointerException e) {}
                break;
        }
    }
    
    public void turnRight() {
        turn((greenfoot.Greenfoot.getRandomNumber(3) + 1) * 90);
    }
}
