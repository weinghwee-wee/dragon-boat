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
public class Articuno extends Bird {
    public Articuno(Graphics g) {
        this.birdBehavior = new RestingBird(g);
    }
}
