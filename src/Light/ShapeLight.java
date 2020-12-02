/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Light;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author WH
 */
public class ShapeLight extends Light{
    final int x = 570;
    final int y = 470;
    //    final int lightNo = 10;
    
    public ShapeLight() {
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(y, x, 20, 20);
        g.fillOval(y + 100, x, 20, 20);
        g.fillOval(y + 200, x, 20, 20);
        g.fillOval(y + 300, x, 20, 20);
        g.fillOval(y + 400, x, 20, 20);
        
//        for (int i = 0; i < lightNo; i++) {
//          //middle lights
//         g.fillOval(y, x, 20, 20);
//         y = y + 50;
//        }
    }
}
