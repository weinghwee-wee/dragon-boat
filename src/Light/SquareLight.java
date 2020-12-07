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
public class SquareLight extends Light{
    final int x = 600;
    final int y = 470;
    
    public SquareLight() {
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(y, x, 20, 20);
        g.fillRect(y + 100, x, 20, 20);
        g.fillRect(y + 200, x, 20, 20);
        g.fillRect(y + 300, x, 20, 20);
        g.fillRect(y + 400, x, 20, 20);
    }
}
