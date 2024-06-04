import greenfoot.*;

/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sound
{   
    private greenfoot.GreenfootSound Musik;
    
    public Sound(String Soundname)
    {    
       Musik = new greenfoot.GreenfootSound(Soundname);
    }
    
    public void spielenLoop()
    {
        Musik.playLoop();
    }
    
    public void spielen()
    {
        Musik.play();
    }
    
    public void stoppen() 
    {
        Musik.stop();
    }
}
