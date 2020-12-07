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

public class CommonButton extends JButton{
    
    public CommonButton(String text, ActionListener al) {
        setText(text);
        setBackground(Color.red);
        setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        setForeground(Color.white);
        addActionListener(al);
    }
}
