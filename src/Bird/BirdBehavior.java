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
public interface BirdBehavior {

    public void move();

    //for drawing purpose
    public int getX();

    public int getY();

    public Image getImage();
}
