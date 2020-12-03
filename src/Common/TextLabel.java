/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author WH
 */
public class TextLabel extends JLabel {
    
    public TextLabel(String text) {
        setText(text);
        setForeground(Color.BLUE);
        setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 24));
    }
}
