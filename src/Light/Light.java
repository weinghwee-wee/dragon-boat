/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Light;

import java.awt.Graphics;

/**
 *
 * @author WH
 */
public abstract class Light {
    Graphics g;
    
    public abstract void render();
    public void setGraphic(Graphics g) {
        this.g = g;
    };
}
