import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Daniel Bode 
 * @version 2024.06.04
 */
public class Game extends World {
    private StartScreen startScreen;
    
    private Scoreboard scoreBoard;
    public static int score;
    
    private LifeGauge l1, l2, l3;
    
    private Sound music;
    private boolean musicOn;
    
    private int count;
    private int spawn;
    private long lastAdded;
    
    private Labyrinth labyrinth;
    
    private Player player;
    
    /**
     * Constructor for objects of class Game.
     * 
     */
    public Game() {    
        super(1422,880, 1);
        
        player= new Player();
        super.addObject(player, 680,495);
        
        labyrinth = new Labyrinth();
        setupLabyrinth();
        
        score = 0;
        scoreBoard = new Scoreboard("Score: 0", 30, Color.YELLOW);
        addObject(scoreBoard, 1350, 30);
        
        l1 = new LifeGauge();
        addObject(l1, 80, 830);
        l2 = new LifeGauge();
        addObject(l2, 140, 830);
        l3 = new LifeGauge();
        addObject(l3, 200, 830);
        
        music = new Sound("Beat.wav");
    }
    
    public void act() {
        playMusic();
        showLifeGauge();
        spawnEnemies();
        scoreBoard.setScore(score);
    }
    
    public void setupLabyrinth() {
        int x=111;
        int y= 29;
        int xCounter=0;
        int yCounter=0;
        for (int o=0;o<840;o=o+52) {
            for (int i=0;i<1300;i=i+52) {
                if (labyrinth.getValue(xCounter,yCounter)==1) {
                    addObject(new Obstacle(), x+i, y+o);
                } else {}
                xCounter++;
            }
            xCounter=0;
            yCounter++;
        }
    }
    
    public void spawnEnemies() {
        long curTime  = System.currentTimeMillis();
        if (count<50) { //spawn a maximum of 50 enemies
            if (curTime >= lastAdded + 1000) {
                spawn = greenfoot.Greenfoot.getRandomNumber(4);
                switch (spawn) {
                    case 0: super.addObject(new Monster(), 1042,600);
                        break;
                    case 1: super.addObject(new Monster(), 1198, 288);
                        break;
                    case 2: super.addObject(new Monster(), 321, 184);
                        break;
                    case 3: super.addObject(new Monster(), 214, 601);
                        break;
                }
                lastAdded = curTime;
                count++;
            }
        } else {
            if (curTime >= lastAdded + 10000) {
                lastAdded  = curTime;
                count=0;
            }
        }
    }
    
    public void showLifeGauge() {
        if (player.health()==2) {
            removeObject(l3);
        }
        if (player.health()==1) {
            removeObject(l2);
        }
        if(player.health()==0) {
            removeObject(l1);
            greenfoot.Greenfoot.stop();
            addObject(new Scoreboard("Game Over",60,Color.BLACK),711,444);
            music.stop();
        }
    }
    
    public void playMusic() {
        if(musicOn==false) {
            music.playLoop();
            musicOn = true;
        }
    }
}
