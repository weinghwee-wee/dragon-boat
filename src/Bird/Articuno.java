/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bird;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author WH
 */
public class Articuno extends Bird {

    public Articuno() {
        birdBehavior = new FlyingBird("articuno");
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
