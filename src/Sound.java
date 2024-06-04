import greenfoot.*;

/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sound
{   
    private greenfoot.GreenfootSound music;
    
    public Sound(String Soundname)
    {    
       music = new greenfoot.GreenfootSound(Soundname);
    }
    
    public void spielenLoop()
    {
        music.playLoop();
    }
    
    public void spielen()
    {
        music.play();
    }
    
    public void stoppen() 
    {
        music.stop();
    }
}
