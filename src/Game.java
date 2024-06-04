import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hintergrund here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{
    private Player SafariFighter;
    
    private Scoreboard Score;
    public static int score;
    
    private LifeGauge l1, l2, l3;
    
    private Sound music;
    private boolean musicOn;
    
    private int count;
    private int spawn;
    
    private long lastAdded;
      
    private Labyrinth L;
    
    private StartScreen Start;
    /**
     * Constructor for objects of class Hintergrund.
     * 
     */
    public Game()
    {    
        super(1422,880, 1);
        
        SafariFighter= new Player();
        super.addObject(SafariFighter, 680,495);
        
        L = new Labyrinth();
        Lab();
        
        score = 0;
        Score = new Scoreboard("Score: 0", 30, Color.YELLOW);
        addObject(Score, 1350, 30);
        
        l1 = new LifeGauge();
        addObject(l1, 80, 830);
        l2 = new LifeGauge();
        addObject(l2, 140, 830);
        l3 = new LifeGauge();
        addObject(l3, 200, 830);
        
        music = new Sound("Beat.wav");
        
        //Start = new StartScreen();
        //super.addObject(Start,711,440);
        //Start.scale(1422,880);
    }
    
    
    public void act() 
    {
        playMusic();
        showLifeGauge();
        spawnEnemies();
        Score.setScore(score);
    }
    
    public void Lab()
    {
        int x=111, y= 29;
        int xCounter=0;
        int yCounter=0;
        for(int o=0;o<840;o=o+52)
        {
            
            for(int i=0;i<1300;i=i+52)
            {
                
                if(L.setValue(xCounter,yCounter)==1)
                {
                    addObject(new Obstacle(), x+i, y+o);
                }
                else
                {}
                xCounter++;
            }
            xCounter=0;
            yCounter++;
        }
    }
    
    public void Labyrinth()
    {
        for(int i=140;i<1640;i=i+60)
        {addObject(new Obstacle(),i,35);}
        for(int i=35;i<1071;i=i+60)
        {addObject(new Obstacle(),140,i);}
        for(int i=140;i<1641;i=i+60)
        {addObject(new Obstacle(),i,1070);}
        for(int i=35;i<1071;i=i+60)
        {addObject(new Obstacle(),1635,i);}
        for(int i=205;i<341;i=i+65)
        {addObject(new Obstacle(),i,100);}
        for(int i=465;i<665;i=i+65)
        {addObject(new Obstacle(),i,165);}
        for(int i=530;i<665;i=i+65)
        {addObject(new Obstacle(),i,230);}
        for(int i=920;i<1506;i=i+65)
        {addObject(new Obstacle(),i,685);}
        for(int i=400;i<791;i=i+65)
        {addObject(new Obstacle(),i,425);}
        for(int i=595;i<791;i=i+65)
        {addObject(new Obstacle(),i,490);}
        for(int i=595;i<791;i=i+65)
        {addObject(new Obstacle(),i,555);}
        for(int i=920;i<1376;i=i+65)
        {addObject(new Obstacle(),i,943);}
        for(int i=205;i<531;i=i+65)
        {addObject(new Obstacle(),i,1008);}
        for(int i=335;i<466;i=i+65)
        {addObject(new Obstacle(),i,555);}
        for(int i=920;i<1051;i=i+65)
        {addObject(new Obstacle(),i,555);}
        for(int i=1175;i<1501;i=i+65)
        {addObject(new Obstacle(),i,425);}
        for(int i=1175;i<1436;i=i+65)
        {addObject(new Obstacle(),i,295);}
        for(int i=920;i<1051;i=i+65)
        {addObject(new Obstacle(),i,100);}
        for(int i=1306;i<1506;i=i+65)
        {addObject(new Obstacle(),i,100);}
        for(int i=920;i<1051;i=i+65)
        {addObject(new Obstacle(),i,360);}
        for(int i=920;i<1051;i=i+65)
        {addObject(new Obstacle(),i,750);}
        for(int i=920;i<1051;i=i+65)
        {addObject(new Obstacle(),i,815);}
        for(int i=1375;i<1441;i=i+65)
        {addObject(new Obstacle(),i,750);}
        for(int i=1375;i<1441;i=i+65)
        {addObject(new Obstacle(),i,880);}
        for(int i=1180;i<1246;i=i+65)
        {addObject(new Obstacle(),i,815);}
        for(int i=685;i<946;i=i+65)
        {addObject(new Obstacle(),725,i);}
        for(int i=685;i<946;i=i+65)
        {addObject(new Obstacle(),790,i);}
        for(int i=685;i<946;i=i+65)
        {addObject(new Obstacle(),465,i);}
        for(int i=425;i<686;i=i+65)
        {addObject(new Obstacle(),205,i);}
        for(int i=685;i<881;i=i+65)
        {addObject(new Obstacle(),335,i);}
        for(int i=100;i<556;i=i+65)
        {addObject(new Obstacle(),1570,i);}
        for(int i=815;i<1011;i=i+65)
        {addObject(new Obstacle(),1570,i);}
        
        addObject(new Obstacle(),270,815); addObject(new Obstacle(),920,490);
        addObject(new Obstacle(),270,880); addObject(new Obstacle(),920,295);
        addObject(new Obstacle(),530,685); addObject(new Obstacle(),920,165);
        addObject(new Obstacle(),660,685); addObject(new Obstacle(),985,295);
        addObject(new Obstacle(),595,815); addObject(new Obstacle(),985,165);
        addObject(new Obstacle(),530,945); addObject(new Obstacle(),1310,165);
        addObject(new Obstacle(),660,945); addObject(new Obstacle(),1050,425);
        addObject(new Obstacle(),270,425); addObject(new Obstacle(),1180,165);
        addObject(new Obstacle(),270,295); addObject(new Obstacle(),1180,230);
        addObject(new Obstacle(),270,230); addObject(new Obstacle(),1115,230);
        addObject(new Obstacle(),335,295); addObject(new Obstacle(),1435,230);
        addObject(new Obstacle(),335,230); addObject(new Obstacle(),1180,490);
        addObject(new Obstacle(),400,295); addObject(new Obstacle(),1180,555);
        addObject(new Obstacle(),530,360); addObject(new Obstacle(),1500,490);
        addObject(new Obstacle(),660,295); addObject(new Obstacle(),1500,555);
        addObject(new Obstacle(),790,295); addObject(new Obstacle(),1370,555);
        addObject(new Obstacle(),790,165); addObject(new Obstacle(),1305,555);
        addObject(new Obstacle(),1505,1010);
    }
    
    public void spawnEnemies()
    {
        long curTime  = System.currentTimeMillis();
        if(count<50)
        {
            if (curTime >= lastAdded + 1000) //5000ms = 5s
                {
                    spawn = greenfoot.Greenfoot.getRandomNumber(4);
                    switch(spawn)
                    {
                        case 0: super.addObject(new Monster(), 1042,600);//100,100
                            break;
                        case 1: super.addObject(new Monster(), 1198, 288);//100,500
                            break;   
                        case 2: super.addObject(new Monster(), 321, 184);//700,90
                            break;     
                        case 3: super.addObject(new Monster(), 214, 601);//700,500
                            break;
                    }
                    lastAdded  = curTime;
                    count++;
                }
        }
        else
        {
            if (curTime >= lastAdded + 10000) //5000ms = 5s
                {
                    lastAdded  = curTime; 
                    count=0;
                }
        }
    }
    
    public void showLifeGauge()
    {
        if(SafariFighter.health()==2)
        {
            removeObject(l3);
        }
        if(SafariFighter.health()==1)
        {
            removeObject(l2);
        }
        if(SafariFighter.health()==0)
        {
            removeObject(l1);
            greenfoot.Greenfoot.stop();
            addObject(new Scoreboard("Game Over",60,Color.BLACK),711,444);
            music.stoppen();
        }
    }
    
    public void playMusic()
    {
        if(musicOn==false)
        {
            music.spielenLoop();
            musicOn = true;
        }
    }
}
