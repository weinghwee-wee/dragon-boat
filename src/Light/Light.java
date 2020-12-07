/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Light;

import java.awt.Graphics;

public abstract class Light {
    final int distance = 100;
    int y_coordinate = 470;
    int x_coordinate;
    
    public abstract void render(Graphics g);
}
