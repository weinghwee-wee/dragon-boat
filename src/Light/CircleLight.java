/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Light;

import java.awt.Color;
import java.awt.Graphics;

public class CircleLight extends Light{
    public CircleLight() {
        x_coordinate = 420;
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        
        for (int i = 0; i < 5; i++) {
            g.fillOval(y_coordinate, x_coordinate, 20, 20);
            y_coordinate = y_coordinate + distance;
        }
    }
}
