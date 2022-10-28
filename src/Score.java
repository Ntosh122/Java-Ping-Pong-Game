
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ntokozo
 */
public class Score extends Rectangle{

    static int width, height;
    int player_1,player_2;
    

    Score(int WIDTH, int HEIGHT) {
      Score.width = WIDTH;
      Score.height = HEIGHT;
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Poppins",Font.PLAIN, 60));
        
        g.drawLine(width/2, 0, width/2, height);
        g.setColor(Color.YELLOW);
        g.drawString(String.valueOf(player_1/10) + String.valueOf(player_1%10), (width/2)-85, 50);
          g.setColor(Color.MAGENTA);
        g.drawString(String.valueOf(player_2/10) + String.valueOf(player_2%10), (width/2)+20, 50);
    }
}
