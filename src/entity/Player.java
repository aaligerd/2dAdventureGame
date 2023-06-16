package entity;

import mainpackage.GamePanel;
import mainpackage.KeyHandler;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        this.x = 100;
        this.y = 100;
        this.speed = 4;
        getPlayerImage();
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            File up1File = new File("C:\\Users\\amerp\\Desktop\\PROGS\\java\\JGD\\My2dGame\\res\\player\\boy_up_1.png");
            File up2File = new File("C:\\Users\\amerp\\Desktop\\PROGS\\java\\JGD\\My2dGame\\res\\player\\boy_up_2.png");
            File down1File = new File("C:\\Users\\amerp\\Desktop\\PROGS\\java\\JGD\\My2dGame\\res\\player\\boy_down_1.png");
            File down2File = new File("C:\\Users\\amerp\\Desktop\\PROGS\\java\\JGD\\My2dGame\\res\\player\\boy_down_2.png");
            File right1File = new File("C:\\Users\\amerp\\Desktop\\PROGS\\java\\JGD\\My2dGame\\res\\player\\boy_right_1.png");
            File right2File = new File("C:\\Users\\amerp\\Desktop\\PROGS\\java\\JGD\\My2dGame\\res\\player\\boy_right_2.png");
            File left1File = new File("C:\\Users\\amerp\\Desktop\\PROGS\\java\\JGD\\My2dGame\\res\\player\\boy_left_1.png");
            File left2File = new File("C:\\Users\\amerp\\Desktop\\PROGS\\java\\JGD\\My2dGame\\res\\player\\boy_left_2.png");
            
            up1 = ImageIO.read(up1File);
            up2 = ImageIO.read(up2File);
            down1 = ImageIO.read(down1File);
            down2 = ImageIO.read(down2File);
            right1 = ImageIO.read(right1File);
            right2 = ImageIO.read(right2File);
            left1 = ImageIO.read(left1File);
            left2 = ImageIO.read(left2File);


        } catch (IOException e) {
            // TODO: handle exception
            System.err.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update() {
        if(keyH.upShift == true||keyH.downShift == true||keyH.leftShift == true||keyH.rightShift == true){
            if (keyH.upShift == true) {
                direction = "up";
                y -= speed;
            }
            if (keyH.downShift == true) {
                direction = "down";
                y += speed;
            }
            if (keyH.leftShift == true) {
                direction = "left";
                x -= speed;
            }
            if (keyH.rightShift == true) {
                direction = "right";
                x += speed;
            }
            spritCount++;
            if(spritCount>12){
                if(spriteNum==1){spriteNum=2;}
                else if(spriteNum==2){spriteNum=1;}
                spritCount=0;
            }
        }
        
    }

    public void draw(Graphics2D g2) {
        // g2.setColor(Color.WHITE);
        // g2.fillRect(x,y,gp.tileSize,gp.tileSize);
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if(spriteNum==1){image = up1;}
                if(spriteNum==2){image = up2;}
                break;
            case "down":
                if(spriteNum==1){image = down1;}
                if(spriteNum==2){image = down2;}
                break;
            case "right":
                if(spriteNum==1){image = right1;}
                if(spriteNum==2){image = right2;}
                break;
            case "left":
                if(spriteNum==1){image = left1;}
                if(spriteNum==2){image = left2;}
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }
}
