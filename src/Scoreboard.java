import greenfoot.*;

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    public GreenfootImage ScoreB;
    private String text;
    private int FontSize;
    private java.awt.Color color;
    
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Scoreboard(String text,int FontSize, Color color)
    {
        ScoreB = new greenfoot.GreenfootImage(text, FontSize, color , null);
        setImage(ScoreB);            
    }
    
    public void act() 
    {
         
    }    
    
    public void setScore(int score)
    {
        ScoreB = new greenfoot.GreenfootImage("Score: "+ score , 30, Color.YELLOW, null);
        setImage(ScoreB);    
    }
}
