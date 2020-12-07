/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Light;

import java.awt.Color;
import java.awt.Graphics;

public class SquareLight extends Light{
    
    public SquareLight() {
        x_coordinate = 530;
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        
        for (int i = 0; i < 5; i++) {
            g.fillRect(y_coordinate, x_coordinate, 20, 20);
            y_coordinate = y_coordinate + distance;
        }
    }
}
