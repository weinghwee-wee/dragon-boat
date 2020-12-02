/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bird;

import Main.DragonBoatSwing;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author WH
 */
public class FlyingBird implements BirdBehavior {

    Image image;
    int x;
    int y;
    String name;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    //pass name of the bird when init
    public FlyingBird(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        //get image of behavior when perform behavior
        String imageURL = "/resources/" + name + "_fly.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imageURL));
        Image resizedImage = imageIcon.getImage().getScaledInstance(screen.width * 20 / 100, screen.height * 20 / 100, Image.SCALE_SMOOTH);

        //without this line cannot paint out.. i also weird
        ImageIcon weird = new ImageIcon(resizedImage);

        //set x , y , image
        setImage(resizedImage);
        setX(screen.width * 50 / 100);
        setY(70);
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
