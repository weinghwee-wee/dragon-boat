/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bird;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class FlyingBird implements BirdBehavior {

    Image image;
    int x;
    int y;
    String name;

    //pass name of the bird when init
    public FlyingBird(String name) {
        this.name = name;
    }

    @Override
    public void move(Graphics g) {
        //get image of behavior when perform behavior
        String imageURL = "/resources/" + name + "_fly.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imageURL));
        Image resizedImage = imageIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);

        ImageIcon imgIcon = new ImageIcon(resizedImage);

        //set x , y , image
        image = resizedImage;
        x = 700;
        y = 70;
        
        g.drawImage(image, x, y, null);
    }

}
