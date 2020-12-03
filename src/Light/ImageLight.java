/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Light;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author WH
 */
public class ImageLight extends Light {
    final int x = 530;
    final int y = 500;
    
    public ImageLight() {
    }
    
    @Override
    public void render(Graphics g) {
        ImageIcon image = new ImageIcon(getClass().getResource("../resources/light_image.png"));
        Image lightImage = image.getImage();
        Image resizedImage = lightImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(resizedImage);
        
        g.drawImage(resizedImage, y, x, null);
        g.drawImage(resizedImage, y + 100, x, null);
        g.drawImage(resizedImage, y + 200, x, null);
        g.drawImage(resizedImage, y + 300, x, null);
        g.drawImage(resizedImage, y + 400, x, null);
    }
}
