import greenfoot.*;

/**
 * 
 * @author Daniel Bode
 * @version 2024.06.04
 */
public class Scoreboard extends Actor {
    public GreenfootImage ScoreB;
    private String text;
    private int FontSize;
    private java.awt.Color color;
    
    public Scoreboard(String text,int FontSize, Color color) {
        ScoreB = new greenfoot.GreenfootImage(text, FontSize, color, null);
        setImage(ScoreB);            
    }
    
    public void act() { }
    
    public void setScore(int score) {
        ScoreB = new greenfoot.GreenfootImage("Score: "+ score , 30, Color.YELLOW, null);
        setImage(ScoreB);    
    }
}
