import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Daniel Bode
 * @version 2024.06.04
 */
public class Player extends Actor {
    private Projectile projectile ;
    private long lastAdded = System.currentTimeMillis();
    private int score;
    private int health = 3;
    private Sound music;
    
    public void act() {
        move();
        shoot();
        loseHealth();
    }
    
    public void loseHealth() {
        if (isTouching(Monster.class)) {
            if (health > 0) {
                health = health - 1;
                super.removeTouching(Monster.class);
            }
        }
    }
    
    public void shoot() {
        if (greenfoot.Greenfoot.isKeyDown("space")) {
            World w = getWorld();
            long curTime  = System.currentTimeMillis();
            if (curTime >= lastAdded + 500) {
                projectile = new Projectile();
                w.addObject(projectile, super.getX(), super.getY());
                projectile.setRotation(this.getRotation());
                music = new Sound("Schusssound.wav");
                music.play();
                lastAdded = curTime;
            }
        }
    }
    
    public void move() {
        if(greenfoot.Greenfoot.isKeyDown("w")) {
            super.turnTowards(super.getX(), super.getY() - 1);
            try {
                if (!(super.getOneObjectAtOffset(0, -25, Obstacle.class).getY() < super.getY() && super.isTouching(Obstacle.class))) {
                    super.move(3);
                }
            }
            catch (NullPointerException e) {
                super.move(3);
            }
        }
        
        if(greenfoot.Greenfoot.isKeyDown("a")) {
            super.turnTowards(super.getX() - 1, super.getY());
            try {
                if (!(super.getOneObjectAtOffset(-25, 0, Obstacle.class).getX() < super.getX())) {
                    super.move(3);
                }
            }
            catch (NullPointerException e) {
                super.move(3);
            }
        }
        
        if(greenfoot.Greenfoot.isKeyDown("s")) {
            super.turnTowards(super.getX(), super.getY() + 1);
            try {
                if (!(super.getOneObjectAtOffset(0, 25, Obstacle.class).getY() > super.getY())) {
                    super.move(3);
                }
            }
            catch (NullPointerException e) {
                super.move(3);
            }
        }
        
        if(greenfoot.Greenfoot.isKeyDown("d"))
        {
            super.turnTowards(super.getX() + 1, super.getY());
            try {
                if (!(super.getOneObjectAtOffset(25, 0, Obstacle.class).getX() > super.getX())) {
                    super.move(3);
                }
            }
            catch (NullPointerException e) {
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
