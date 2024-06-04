import greenfoot.*;

/**
 * 
 * @author Daniel Bode
 * @version 2024.06.04
 */
public class Sound {   
    private greenfoot.GreenfootSound music;
    
    public Sound(String soundname) {    
       music = new greenfoot.GreenfootSound(soundname);
    }
    
    public void playLoop() {
        music.playLoop();
    }
    
    public void play() {
        music.play();
    }
    
    public void stop() {
        music.stop();
    }
}
