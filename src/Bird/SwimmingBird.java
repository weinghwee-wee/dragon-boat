/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bird;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Wah
 */
public class SwimmingBird implements BirdBehavior {

    Image image;
    int x;
    int y;
    String name;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    public SwimmingBird(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        //read image 
        String imageURL = "/resources/" + name + "_swim.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imageURL));
        Image resizedImage = imageIcon.getImage().getScaledInstance(screen.width * 10 / 100, screen.height * 10 / 100, Image.SCALE_SMOOTH);
        ImageIcon weird = new ImageIcon(resizedImage);
        //set x , y , image
        setImage(resizedImage);
        setX(screen.width * 10 / 100);
        setY(screen.height * 60 / 100);
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
