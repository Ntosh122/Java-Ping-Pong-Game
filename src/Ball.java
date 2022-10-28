
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ntokozo
 */
public class Ball extends Rectangle{
    
    Random rand;
    int xVel,yVel;
    int inital_speed=3;

    Ball(int x, int y, int width, int height) {
        super(x,y, width, height);
        rand = new Random();
        int rXDirection = rand.nextInt(2);
        if(rXDirection==0){
            rXDirection--;
        }   
        setXDirection(rXDirection*inital_speed);
        
         int rYDirection = rand.nextInt(2);
        if(rYDirection==0){
            rYDirection--;
        }  
        setYDirection(rYDirection*inital_speed);
    }
    public void setXDirection(int randomXDirection){
        xVel = randomXDirection;
    }
    public void setYDirection(int randomYDirection){
        yVel = randomYDirection;
    }
    public void move(){
        x+=xVel;
        y+=yVel;
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x, y, width, height);
    }
}
