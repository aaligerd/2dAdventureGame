package mainpackage;

import javax.swing.JPanel;
import entity.Player;
import tiles.TilesManager;

import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    int x=100;
    int y=100;
    final int fps=60;
    final int originalTilesSize=16;
    final int scale=3;
    public final int tileSize=originalTilesSize*scale;
    public final int maxScreenCol=16;
    public final int maxScreenRow=12;
    public final int screenWidth=maxScreenCol*tileSize;//768px 
    public final int screenHeight=maxScreenRow*tileSize;//576px
    Thread gameThread;
    final KeyHandler keyH;

    //game player
    Player player;

    //make the tile
    TilesManager tManager;
    public GamePanel(){
       
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        keyH=new KeyHandler();
        addKeyListener(keyH);
        tManager=new TilesManager(this);
        player=new Player(this, keyH);
        this.setFocusable(true);
    }
    public void startGame(){
        gameThread=new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double drawTime=1000000000/fps;
        double nextDrawTime=System.nanoTime()+drawTime;
        try {
            while(gameThread !=null){
            update();
            repaint();
            double reamaingTime=nextDrawTime-System.nanoTime();
            reamaingTime/=1000000;
            if(reamaingTime<0){reamaingTime=0;}
            Thread.sleep((long)reamaingTime);
            nextDrawTime+=drawTime;
        }
        } catch (Exception e) {
            System.err.println(e);
        }
        
        
    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        tManager.drawTiles(g2);
        player.draw(g2);

        g2.dispose();
    }
    
}
