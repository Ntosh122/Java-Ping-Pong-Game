/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong.official_game;

/**
 *
 * @author Ntokozo
 */
import java.awt.Graphics;

public interface Game_interface {
    public void move();
    public void newPaddles();
    public void newBall();
    public void draw(Graphics g);
    public void checkCollision();
}
