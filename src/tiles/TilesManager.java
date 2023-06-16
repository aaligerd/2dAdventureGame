package tiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.imageio.ImageIO;
import mainpackage.GamePanel;


public class TilesManager {
    GamePanel gp;
    Tile tiles[];
    int tileNum=6;
    final String tileNames[];
    public int[][] mapNum;
    private final String pathTiles="C:\\Users\\amerp\\Desktop\\PROGS\\java\\JGD\\My2dGame\\res\\tiles\\";
    private final String pathMap="C:\\Users\\amerp\\Desktop\\PROGS\\java\\JGD\\My2dGame\\res\\map\\";


    public TilesManager(GamePanel gp){
        tileNames=new String[]{"earth","grass","sand","tree","wall","water"};
        this.gp=gp;
        tiles=new Tile[tileNum];
        mapNum=new int[gp.maxScreenRow][gp.maxScreenCol];
        getTileImage();
        loadMap();
    
    }
    public void getTileImage(){
        try {
            

            for(int i=0;i<tileNum;i++){
                File f=new File(pathTiles+tileNames[i]+".png");
                tiles[i]=new Tile();
                tiles[i].image=ImageIO.read(f);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap(){
        try {

            FileReader fr=new FileReader(pathMap+"map1.txt");
            BufferedReader br=new BufferedReader(fr);
            for(int i=0;i<gp.maxScreenRow;i++){
                String nums[]=br.readLine().split(" ");
                int j=0;
                for (String num : nums) {
                    int k=Integer.parseInt(num);
                    mapNum[i][j]=k;
                    j++;
                }
                
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawTiles(Graphics2D g2){
        int x=0;
        int y=0;
        int col=0;
        int row=0;
        while(col <gp.maxScreenCol && row<gp.maxScreenRow){
            g2.drawImage(tiles[mapNum[row][col]].image, x, y, gp.tileSize,gp.tileSize,null);
            x+=gp.tileSize;
            col++;
            if(col==gp.maxScreenCol){
                col=0;
                x=0;
                y+=gp.tileSize;
                row++;
            }
        }
            
            
        
    }
}
