/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fish;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Fish {

    public Fish() {
    }

    public void display(Graphics g) {
        ImageIcon image_fish_1 = new ImageIcon(getClass().getResource("../resources/fish_1.png"));
        ImageIcon image_fish_2 = new ImageIcon(getClass().getResource("../resources/fish_2.png"));
        ImageIcon image_fish_3 = new ImageIcon(getClass().getResource("../resources/fish_3.png"));
        
        Image fish1Image = image_fish_1.getImage();
        Image fish2Image = image_fish_2.getImage();
        Image fish3Image = image_fish_3.getImage();
        
        Image resizedFish1Image = fish1Image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Image resizedFish2Image = fish2Image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Image resizedFish3Image = fish3Image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        
        image_fish_1 = new ImageIcon(resizedFish1Image);
        image_fish_2 = new ImageIcon(resizedFish2Image);
        image_fish_3 = new ImageIcon(resizedFish3Image);
        
        g.drawImage(resizedFish1Image, 1150, 450, null);
        g.drawImage(resizedFish2Image, 80, 570, null);
        g.drawImage(resizedFish3Image, 800, 670, null);
        
    }

    public void remove() {
    }
}
