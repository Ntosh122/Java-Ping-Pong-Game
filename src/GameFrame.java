
import java.awt.Color;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ntokozo
 */
public class GameFrame extends JFrame{
    
    GameFrame(){
        this.add(new GamePanel());
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
        this.setTitle("Ping Pong");
        this.setBackground(Color.decode("#122c5c"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
