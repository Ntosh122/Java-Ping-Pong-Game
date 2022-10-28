
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import pingpong.official_game.Game_interface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ntokozo
 */
public class GamePanel extends JPanel implements Game_interface, Runnable{

    static final int  WIDTH = 1000;
    static final int HEIGHT = (int)(WIDTH * (0.5555));
    static final Dimension screen = new Dimension(WIDTH, HEIGHT);
   static final int Ball_Diameter = 20;
   static final int paddle_width=25;
    static final int paddle_height=100;
    
    Thread th;
    Image img;
    Graphics graphics;
    Random rand;
    Paddles paddle_1;
    Paddles paddle_2;
    Ball ball;
    Score score;
    public GamePanel() {
        
        newPaddles();
        newBall();
        score = new Score(WIDTH, HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(screen);
        
        //start game thread
        th= new Thread(this);
        th.start();
    }
    
   
    @Override
    public void run() {
        
       //The game will run at 60fps   
      long lastTime = System.nanoTime();
      double amountofTicks =60.0;
      double ns = 1000000000 / amountofTicks;
      double delta = 0;
      
      while(true){
          long now = System.nanoTime();
          delta+=(now-lastTime)/ns;
          lastTime = now;
          if(delta>=1){
              move();
              checkCollision();
              repaint();
              delta--;
          }
      }
    }

    @Override
    public void move() {
        paddle_1.move();
        paddle_2.move();
        ball.move();
    }

    @Override
    public void newPaddles() {
        //creating new paddles for player-1 & player-2
       paddle_1 = new Paddles(0, (HEIGHT/2) - (paddle_height/2),paddle_width, paddle_height, 1);
       paddle_2 = new Paddles(WIDTH-paddle_width, (HEIGHT/2) - (paddle_height/2),paddle_width, paddle_height, 2);
    }
 
    @Override
    public void newBall() {
        //a new ball is created & when a game starts the ball starts at different axis
         rand = new Random();
         ball = new Ball((WIDTH/2) - (Ball_Diameter/2), rand.nextInt(HEIGHT-Ball_Diameter), Ball_Diameter, Ball_Diameter);
    }

    @Override
    public void draw(Graphics g) {
        //draw the paddles, ball and score        
        paddle_1.draw(g);
        paddle_2.draw(g);
        ball.draw(g);
        score.draw(g);
    }
    @Override
    public void paint(Graphics g){
        img = createImage(getWidth(),getHeight());
        graphics = img.getGraphics();
        draw(graphics);
        g.drawImage(img, 0, 0, this);
    }

    @Override
    public void checkCollision() {
//        ball bounce
        if(ball.y<=0)
            ball.setYDirection(-ball.yVel);
        if(ball.y>=HEIGHT-Ball_Diameter)
            ball.setYDirection(-ball.yVel);
       
//        ball bounce of paddles
        if(ball.intersects(paddle_1)){
               ball.xVel = Math.abs(ball.xVel);
               ball.xVel++;
               if(ball.yVel>0){
                   ball.yVel++;
               }else{
                   ball.yVel--;
               }
               ball.setXDirection(ball.xVel);
               ball.setYDirection(ball.yVel);
        }
        if(ball.intersects(paddle_2)){
               ball.xVel = Math.abs(ball.xVel);
               ball.xVel++;
               if(ball.yVel>0){
                   ball.yVel++;
               }else{
                   ball.yVel--;
               }
               ball.setXDirection(-ball.xVel);
               ball.setYDirection(ball.yVel);
        }
//         score of 1point and create new paddle and ball

        
//        paddles on the window edges
        if(paddle_1.y <=0)
            paddle_1.y = 0;
        if(paddle_1.y >= (HEIGHT - paddle_height))
            paddle_1.y = HEIGHT - paddle_height;
        
          if(paddle_2.y <=0)
            paddle_2.y = 0;
        if(paddle_2.y >= (HEIGHT - paddle_height))
            paddle_2.y = HEIGHT - paddle_height;
        
        if(ball.x<=0){
               score.player_2++;
               newPaddles();
               newBall();
        }   
         if(ball.x>=WIDTH-Ball_Diameter){
               score.player_1++;
               newPaddles();
               newBall();
        }   
    }
    public class AL implements KeyListener{
        
        @Override
        public void keyTyped(KeyEvent e) {
        
        }

        @Override
        public void keyPressed(KeyEvent e) {
           paddle_1.keyPressed(e);
            paddle_2.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
          paddle_1.keyReleased(e);
           paddle_2.keyReleased(e);
        }
    }
}
