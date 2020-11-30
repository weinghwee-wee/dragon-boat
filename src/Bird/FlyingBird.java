/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bird;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author WH
 */
public class FlyingBird implements BirdBehavior {
    Graphics g;
    
    public FlyingBird(Graphics g) {
        this.g = g;
    }
    @Override
    public void move() {
        ImageIcon image = new ImageIcon(getClass().getResource("../resources/articuno_fly.png"));
        Image birdImage = image.getImage();
        Image resizedImage = birdImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        g.drawImage(resizedImage, 50, 50, null);
    }
    
}
