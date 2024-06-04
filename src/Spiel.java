import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hintergrund here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spiel extends World
{
    private Spieler SafariFighter;
    
    private Scoreboard Score;
    public static int score;
    
    private Lebensanzeige l1, l2, l3;
    
    private Sound Musik;
    private boolean MusikAn;
    
    private int Anzahl;
    private int spawn;
    
    private long lastAdded;
      
    private Labyrinth L;
    
    private Startbildschirm Start;
    /**
     * Constructor for objects of class Hintergrund.
     * 
     */
    public Spiel()
    {    
        super(1422,880, 1);
        
        SafariFighter= new Spieler();
        super.addObject(SafariFighter, 680,495);
        
        L = new Labyrinth();
        Lab();
        
        score = 0;
        Score = new Scoreboard("Score: 0", 30, Color.YELLOW);
        addObject(Score, 1350, 30);
        
        l1 = new Lebensanzeige();
        addObject(l1, 80, 830);
        l2 = new Lebensanzeige();
        addObject(l2, 140, 830);
        l3 = new Lebensanzeige();
        addObject(l3, 200, 830);
        
        Musik = new Sound("Beat.wav");
        
        //Start = new Startbildschirm();
        //super.addObject(Start,711,440);
        //Start.scale(1422,880);
    }
    
    
    public void act() 
    {
        MusikSpielen();
        LebenAnzeigen();
        GegnerSpawnen();
        Score.setScore(score);
    }
    
    public void Lab()
    {
        int x=111, y= 29;
        int ZaehlerX=0;
        int ZaehlerY=0;
        for(int o=0;o<840;o=o+52)
        {
            
            for(int i=0;i<1300;i=i+52)
            {
                
                if(L.WertGeben(ZaehlerX,ZaehlerY)==1)
                {
                    addObject(new Hindernis(), x+i, y+o);
                }
                else
                {}
                ZaehlerX++;
            }
            ZaehlerX=0;
            ZaehlerY++;
        }
    }
    
    public void Labyrinth()
    {
        for(int i=140;i<1640;i=i+60)
        {addObject(new Hindernis(),i,35);}
        for(int i=35;i<1071;i=i+60)
        {addObject(new Hindernis(),140,i);}
        for(int i=140;i<1641;i=i+60)
        {addObject(new Hindernis(),i,1070);}
        for(int i=35;i<1071;i=i+60)
        {addObject(new Hindernis(),1635,i);}
        for(int i=205;i<341;i=i+65)
        {addObject(new Hindernis(),i,100);}
        for(int i=465;i<665;i=i+65)
        {addObject(new Hindernis(),i,165);}
        for(int i=530;i<665;i=i+65)
        {addObject(new Hindernis(),i,230);}
        for(int i=920;i<1506;i=i+65)
        {addObject(new Hindernis(),i,685);}
        for(int i=400;i<791;i=i+65)
        {addObject(new Hindernis(),i,425);}
        for(int i=595;i<791;i=i+65)
        {addObject(new Hindernis(),i,490);}
        for(int i=595;i<791;i=i+65)
        {addObject(new Hindernis(),i,555);}
        for(int i=920;i<1376;i=i+65)
        {addObject(new Hindernis(),i,943);}
        for(int i=205;i<531;i=i+65)
        {addObject(new Hindernis(),i,1008);}
        for(int i=335;i<466;i=i+65)
        {addObject(new Hindernis(),i,555);}
        for(int i=920;i<1051;i=i+65)
        {addObject(new Hindernis(),i,555);}
        for(int i=1175;i<1501;i=i+65)
        {addObject(new Hindernis(),i,425);}
        for(int i=1175;i<1436;i=i+65)
        {addObject(new Hindernis(),i,295);}
        for(int i=920;i<1051;i=i+65)
        {addObject(new Hindernis(),i,100);}
        for(int i=1306;i<1506;i=i+65)
        {addObject(new Hindernis(),i,100);}
        for(int i=920;i<1051;i=i+65)
        {addObject(new Hindernis(),i,360);}
        for(int i=920;i<1051;i=i+65)
        {addObject(new Hindernis(),i,750);}
        for(int i=920;i<1051;i=i+65)
        {addObject(new Hindernis(),i,815);}
        for(int i=1375;i<1441;i=i+65)
        {addObject(new Hindernis(),i,750);}
        for(int i=1375;i<1441;i=i+65)
        {addObject(new Hindernis(),i,880);}
        for(int i=1180;i<1246;i=i+65)
        {addObject(new Hindernis(),i,815);}
        for(int i=685;i<946;i=i+65)
        {addObject(new Hindernis(),725,i);}
        for(int i=685;i<946;i=i+65)
        {addObject(new Hindernis(),790,i);}
        for(int i=685;i<946;i=i+65)
        {addObject(new Hindernis(),465,i);}
        for(int i=425;i<686;i=i+65)
        {addObject(new Hindernis(),205,i);}
        for(int i=685;i<881;i=i+65)
        {addObject(new Hindernis(),335,i);}
        for(int i=100;i<556;i=i+65)
        {addObject(new Hindernis(),1570,i);}
        for(int i=815;i<1011;i=i+65)
        {addObject(new Hindernis(),1570,i);}
        
        addObject(new Hindernis(),270,815); addObject(new Hindernis(),920,490);
        addObject(new Hindernis(),270,880); addObject(new Hindernis(),920,295);
        addObject(new Hindernis(),530,685); addObject(new Hindernis(),920,165);
        addObject(new Hindernis(),660,685); addObject(new Hindernis(),985,295);
        addObject(new Hindernis(),595,815); addObject(new Hindernis(),985,165);
        addObject(new Hindernis(),530,945); addObject(new Hindernis(),1310,165);
        addObject(new Hindernis(),660,945); addObject(new Hindernis(),1050,425);
        addObject(new Hindernis(),270,425); addObject(new Hindernis(),1180,165);
        addObject(new Hindernis(),270,295); addObject(new Hindernis(),1180,230);
        addObject(new Hindernis(),270,230); addObject(new Hindernis(),1115,230);
        addObject(new Hindernis(),335,295); addObject(new Hindernis(),1435,230);
        addObject(new Hindernis(),335,230); addObject(new Hindernis(),1180,490);
        addObject(new Hindernis(),400,295); addObject(new Hindernis(),1180,555);
        addObject(new Hindernis(),530,360); addObject(new Hindernis(),1500,490);
        addObject(new Hindernis(),660,295); addObject(new Hindernis(),1500,555);
        addObject(new Hindernis(),790,295); addObject(new Hindernis(),1370,555);
        addObject(new Hindernis(),790,165); addObject(new Hindernis(),1305,555);
        addObject(new Hindernis(),1505,1010);
    }
    
    public void GegnerSpawnen()
    {
        long curTime  = System.currentTimeMillis();
        if(Anzahl<50)
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
                    Anzahl++;
                }
        }
        else
        {
            if (curTime >= lastAdded + 10000) //5000ms = 5s
                {
                    lastAdded  = curTime; 
                    Anzahl=0;
                }
        }
    }
    
    public void LebenAnzeigen()
    {
        if(SafariFighter.Leben()==2)
        {
            removeObject(l3);
        }
        if(SafariFighter.Leben()==1)
        {
            removeObject(l2);
        }
        if(SafariFighter.Leben()==0)
        {
            removeObject(l1);
            greenfoot.Greenfoot.stop();
            addObject(new Scoreboard("Game Over",60,Color.BLACK),711,444);
            Musik.stoppen();
        }
    }
    
    public void MusikSpielen()
    {
        if(MusikAn==false)
        {
            Musik.spielenLoop();
            MusikAn = true;
        }
    }
}
