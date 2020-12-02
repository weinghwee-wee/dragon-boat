/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author WH
 */
public class CommonButton {
    String text;
    ActionListener al;
    
    public CommonButton(String text, ActionListener al) {
        this.text = text;
        this.al = al;
    }
    
    public JButton getButton() {
        JButton jButton = new JButton(text);
        jButton.setBackground(Color.red);
        jButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        jButton.setForeground(Color.white);
        jButton.addActionListener(al);
        
        return jButton;
    }
}
