import greenfoot.*;

/**
 * 
 * @author Daniel Bode
 * @version 2024.06.04
 */
public class StartScreen extends World {
    private int counter;
    
    public StartScreen() {
        super(1422, 880, 1);        
    }
    
    public void act() {
        if (Greenfoot.getKey() != null) {
            Greenfoot.setWorld(new Game());
        }
    }
}
