import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
     /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Projectile banana ;
    private long lastAdded = System.currentTimeMillis();
    private int score;
    private int health=3;
    private Sound music;
    
    public void act() 
    {
        move();
        shoot();
        loseHealth();
    }
    
    public void loseHealth()
    {
        if(isTouching(Monster.class))
        {
            if(health>0)
            {
                health=health-1;
                super.removeTouching(Monster.class);
            }
        }
    }
    
    public void shoot()
    {
        if(greenfoot.Greenfoot.isKeyDown("space"))
        {
            World w = getWorld();
            long curTime  = System.currentTimeMillis();
            if (curTime >= lastAdded + 500) //5000ms = 5s
                {
                    banana = new Projectile();
                    w.addObject(banana,super.getX(),super.getY());
                    banana.setRotation(this.getRotation());
                    music = new Sound("Schusssound.wav");
                    music.spielen();
                    lastAdded  = curTime;
                }
        }
    }
    
    public void move()
    {
        if(greenfoot.Greenfoot.isKeyDown("w"))
        {
            super.turnTowards(super.getX(), super.getY()-1);
            try
            {
                if(super.getOneObjectAtOffset(0,-25, Obstacle.class).getY()<super.getY()&&super.isTouching(Obstacle.class))
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
                if(super.getOneObjectAtOffset(-25,0,Obstacle.class).getX()<super.getX())
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
                if(super.getOneObjectAtOffset(0,25,Obstacle.class).getY()>super.getY())
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
                if(super.getOneObjectAtOffset(25,0,Obstacle.class).getX()>super.getX())
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
    
    public int health()
    {
        return health;
    }
    
    public int score()
    {
        return score;
    }
}

