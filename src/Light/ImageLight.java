/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Light;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author WH
 */
public class ImageLight extends Light {
    final int x = 310;
    int y = 400;
    final int lightNo = 10;
    
    public ImageLight() {
    }
    
    @Override
    public void render() {
        ImageIcon image = new ImageIcon(getClass().getResource("../resources/light_image.png"));
        Image birdImage = image.getImage();
        Image resizedImage = birdImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        g.drawImage(resizedImage, 50, 50, null);
    }
}
