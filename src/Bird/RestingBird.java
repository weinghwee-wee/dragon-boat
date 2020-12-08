/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bird;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class RestingBird implements BirdBehavior {

    Image image;
    int x;
    int y;
    String name;

    public RestingBird(String name) {
        this.name = name;
    }

    @Override
    public void move(Graphics g) {
        //read image 
        String imageURL = "/resources/" + name + "_rest.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imageURL));

        if (name.equalsIgnoreCase("articuno")) {
            Image resizedImage = imageIcon.getImage().getScaledInstance(150, 125, Image.SCALE_SMOOTH);
            ImageIcon weird = new ImageIcon(resizedImage);

            image = resizedImage;
            x = 140;
            y = 120;

        } else if (name.equalsIgnoreCase("penguin")) {
            Image resizedImage = imageIcon.getImage().getScaledInstance(90, 115, Image.SCALE_SMOOTH);
            ImageIcon weird = new ImageIcon(resizedImage);

            image = resizedImage;
            x = 60;
            y = 190;
        }

        g.drawImage(image, x, y, null);

    }

}
