import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spieler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spieler extends Actor
{
     /**
     * Act - do whatever the Spieler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Projektil banana ;
    private long lastAdded = System.currentTimeMillis();
    private int Punkte;
    private int Leben=3;
    private Sound Musik;
    
    public void act() 
    {
        Bewegen();
        Schießen();
        LebenVerlieren();
    }
    
    public void LebenVerlieren()
    {
        if(isTouching(Monster.class))
        {
            if(Leben>0)
            {
                Leben=Leben-1;
                super.removeTouching(Monster.class);
            }
        }
    }
    
    public void Schießen()
    {
        if(greenfoot.Greenfoot.isKeyDown("space"))
        {
            World w = getWorld();
            long curTime  = System.currentTimeMillis();
            if (curTime >= lastAdded + 500) //5000ms = 5s
                {
                    banana = new Projektil();
                    w.addObject(banana,super.getX(),super.getY());
                    banana.setRotation(this.getRotation());
                    Musik = new Sound("Schusssound.wav");
                    Musik.spielen();
                    lastAdded  = curTime;
                }
        }
    }
    
    public void Bewegen()
    {
        if(greenfoot.Greenfoot.isKeyDown("w"))
        {
            super.turnTowards(super.getX(), super.getY()-1);
            try
            {
                if(super.getOneObjectAtOffset(0,-25, Hindernis.class).getY()<super.getY()&&super.isTouching(Hindernis.class))
                {}
                else
                {
                    super.move(3);                    
                }
            }   
            catch (NullPointerException e)
            {
                super.move(3);
            }
        }
        if(greenfoot.Greenfoot.isKeyDown("a"))
        {
            super.turnTowards(super.getX()-1, super.getY());
            try
            {
                if(super.getOneObjectAtOffset(-25,0,Hindernis.class).getX()<super.getX())
                {}
                else
                {
                    super.move(3);
                }
            } 
            catch (NullPointerException e)
            {
                super.move(3);
            }
        }
        if(greenfoot.Greenfoot.isKeyDown("s"))
        {
            super.turnTowards(super.getX(), super.getY()+1);
            try
            {
                if(super.getOneObjectAtOffset(0,25,Hindernis.class).getY()>super.getY())
                {}
                else
                {
                    super.move(3);
                }
            }
            catch (NullPointerException e)
            {
                super.move(3);
            }
        }
        if(greenfoot.Greenfoot.isKeyDown("d"))
        {
            super.turnTowards(super.getX()+1, super.getY());
            try
            {
                if(super.getOneObjectAtOffset(25,0,Hindernis.class).getX()>super.getX())
                {}
                else
                {
                    super.move(3);
                }
            }
            catch (NullPointerException e)
            {
                super.move(3);
            }
        }
    }
    
    public int Leben()
    {
        return Leben;
    }
    
    public int Punkte()
    {
        return Punkte;
    }
}

