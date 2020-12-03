/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author WH
 */
public class ButtonContainer extends JPanel {
    
    public ButtonContainer(String category, CommonButton[] cmbs) {
        setBackground(Color.white);
        add(new TextLabel(category));
        
        for (int i = 0; i < cmbs.length; i ++) {
            add(cmbs[i]);
        }
    }
}
