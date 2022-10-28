
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ntokozo
 */
public class Paddles extends Rectangle{
    
    int id;
    int yVelocity;
    
    public Paddles() {
    }

    Paddles(int x, int y, int paddle_width, int paddle_height, int id) {
        super(x,y,paddle_width,paddle_height);
        this.id = id;
    }
    
    public void keyPressed(KeyEvent evt){
        switch(id){
            case 1 :
                if(evt.getKeyCode() == KeyEvent.VK_W){
                    setYDirection(-10);
                    move();
                }
                
                if(evt.getKeyCode() == KeyEvent.VK_S){
                    setYDirection(10);
                    move();
                }
                break;
                case 2 :
                if(evt.getKeyCode() == KeyEvent.VK_UP){
                    setYDirection(-10);
                    move();
                }
                
                if(evt.getKeyCode() == KeyEvent.VK_DOWN){
                    setYDirection(10);
                    move();
                }
                break;
        }
    }
    public void keyReleased(KeyEvent evt){
        switch(id){
            case 1 :
                //  KeyEvent.VK_W - is for the up button        
                if(evt.getKeyCode() == KeyEvent.VK_W){
                    setYDirection(0);
                    move();
                }
                   //  KeyEvent.VK_S - is for the down button        
                if(evt.getKeyCode() == KeyEvent.VK_S){
                    setYDirection(0);
                    move();
                }
                break;
                case 2 :
                if(evt.getKeyCode() == KeyEvent.VK_UP){
                    setYDirection(0);
                    move();
                }
                
                if(evt.getKeyCode() == KeyEvent.VK_DOWN){
                    setYDirection(0);
                    move();
                }
                break;
        }
    }
    public void setYDirection(int yDirection){
        yVelocity = yDirection;
    }
     public void move(){
        y += yVelocity;
    }
     public void draw(Graphics g){
         if(id==1)
             g.setColor(Color.YELLOW);
         else
             g.setColor(Color.MAGENTA);
         g.fillRect(x, y, width, height);
     }
}
