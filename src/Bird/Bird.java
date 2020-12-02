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
public abstract class Bird {

    BirdBehavior birdBehavior;

    public void performBirdBehavior() {
        birdBehavior.move();
    }

    public void setBirdBehavior(BirdBehavior birdBehavior) {
        this.birdBehavior = birdBehavior;
    }

    //all bird class child implmented to give the position and image
    public abstract int getX();

    public abstract int getY();

    public abstract Image getImage();

}
