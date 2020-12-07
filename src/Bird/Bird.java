/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bird;

import java.awt.Graphics;

public abstract class Bird {

    BirdBehavior birdBehavior;

    public void performBirdBehavior(Graphics g) {
        birdBehavior.move(g);
    }

    public void setBirdBehavior(BirdBehavior birdBehavior) {
        this.birdBehavior = birdBehavior;
    }

}
