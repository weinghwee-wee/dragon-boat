/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bird;

import java.awt.Image;

/**
 *
 * @author Wah
 */
public class Penguin extends Bird {

    public Penguin() {
        birdBehavior = new SwimmingBird("penguin");
    }

    public int getX() {
        return birdBehavior.getX();
    }

    public int getY() {
        return birdBehavior.getY();
    }

    public Image getImage() {
        return birdBehavior.getImage();
    }
}
