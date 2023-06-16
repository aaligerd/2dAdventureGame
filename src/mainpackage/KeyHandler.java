package mainpackage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    public boolean upShift,downShift,rightShift,leftShift;

    @Override
    public void keyTyped(KeyEvent e) {        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        // TODO Auto-generated method stub
        if(ke.getKeyCode()==65){
            leftShift=true;
        }
        if(ke.getKeyCode()==87){
            upShift=true ;
        }
        if(ke.getKeyCode()==83){
            downShift=true;
        }
        if(ke.getKeyCode()==68){
            rightShift=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        // TODO Auto-generated method stub
        if(ke.getKeyCode()==65){
            leftShift=false;
        }
        if(ke.getKeyCode()==87){
            upShift=false ;
        }
        if(ke.getKeyCode()==83){
            downShift=false;
        }
        if(ke.getKeyCode()==68){
            rightShift=false;
        }
    }
    
}
