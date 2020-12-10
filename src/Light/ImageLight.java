/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Light;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ImageLight extends Light {
    
    public ImageLight() {
        x_coordinate = 420;
    }
    
    @Override
    public void render(Graphics g) {
        ImageIcon image = new ImageIcon(getClass().getResource("../resources/light_image.png"));
        Image lightImage = image.getImage();
        Image resizedImage = lightImage.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(resizedImage);
        
        for (int i = 0; i < 5; i++) {
            g.drawImage(resizedImage, y_coordinate, x_coordinate, null);
            y_coordinate = y_coordinate + distance;
        }
    }
}
