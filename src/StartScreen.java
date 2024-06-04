import greenfoot.*;

/**
 * 
 * @author Daniel Bode
 * @version 2024.06.04
 */
public class StartScreen extends Actor {
    public void act() { }
    
    public void scale(int x, int y) {
        GreenfootImage start = new GreenfootImage("01_startscreen.png");
        start.scale(x, y);
        start.drawImage(start, x, y);
    }
}
