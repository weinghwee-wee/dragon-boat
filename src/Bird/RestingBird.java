/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bird;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import Main.DragonBoatSwing;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author WH
 */
public class RestingBird implements BirdBehavior {

    Image image;
    int x;
    int y;
    String name;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    public RestingBird(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        //read image 
        String imageURL = "/resources/" + name + "_rest.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imageURL));

        if (name.equalsIgnoreCase("articuno")) {
            Image resizedImage = imageIcon.getImage().getScaledInstance(screen.width * 15 / 100, screen.height * 15 / 100, Image.SCALE_SMOOTH);
            ImageIcon weird = new ImageIcon(resizedImage);

            //set x , y , image
            setImage(resizedImage);
            setX(screen.width * 8 / 100);
            setY(screen.height * 9 / 100);
        } else if (name.equalsIgnoreCase("penguin")) {
            Image resizedImage = imageIcon.getImage().getScaledInstance(screen.width * 8 / 100, screen.height * 12 / 100, Image.SCALE_SMOOTH);
            ImageIcon weird = new ImageIcon(resizedImage);

            //set x , y , image
            setImage(resizedImage);
            setX(screen.width * 3 / 100);
            setY(screen.height * 20 / 100);
        }

    }

    //getter and setter
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
