/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bird;

import java.awt.Graphics;

/**
 *
 * @author WH
 */
public abstract class Bird {
    public BirdBehavior birdBehavior;
    
    public void move(){
        birdBehavior.move();
    }
    
    public void setBirdBehavior(BirdBehavior birdBehavior) {
        this.birdBehavior = birdBehavior;
    }
}
