/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bird;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class SwimmingBird implements BirdBehavior {

    Image image;
    int x;
    int y;
    String name;

    public SwimmingBird(String name) {
        this.name = name;
    }

    @Override
    public void move(Graphics g) {
        //read image 
        String imageURL = "/resources/" + name + "_swim.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imageURL));
        Image resizedImage = imageIcon.getImage().getScaledInstance(125, 75, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(resizedImage);

        //set x , y , image
        image = resizedImage;
        x = 250;
        y = 475;

        g.drawImage(image, x, y, null);
    }

}
