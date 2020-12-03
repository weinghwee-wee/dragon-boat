/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fish;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


/**
 *
 * @author ganze
 */
public class Fish {

    public Fish() {
    }

    public void display(Graphics g) {
        ImageIcon image_blue_fish = new ImageIcon(getClass().getResource("../resources/blue_fish.png"));
        ImageIcon image_orange_fish = new ImageIcon(getClass().getResource("../resources/orange_fish.png"));
        Image blueFishImage = image_blue_fish.getImage();
        Image orangeFishImage = image_orange_fish.getImage();
        Image resizedBlueFishImage = blueFishImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Image resizedOrangeFishImage = orangeFishImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        image_blue_fish = new ImageIcon(resizedBlueFishImage);
        image_orange_fish = new ImageIcon(resizedOrangeFishImage);
        g.drawImage(resizedBlueFishImage, 1100, 350, null);
        g.drawImage(resizedOrangeFishImage, 80, 470, null);
    }

    public void remove() {
    }
}
